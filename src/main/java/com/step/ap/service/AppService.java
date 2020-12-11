package com.step.ap.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.step.ap.base.BaseService;
import com.step.ap.entity.App;
import com.step.ap.entity.AppVersion;
import com.step.ap.exception.MyException;
import com.step.ap.vo.AppUploadVo;
import com.step.ap.vo.AppVo;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 服务类
 */
@Service
@Transactional
@AllArgsConstructor
public class AppService extends BaseService<App> {

    private final AppVersionService appVersionService;
    private final FileSystemStorageService storageService;

    public List<AppVo> getList() {
        List<App> list = super.list(new LambdaQueryWrapper<App>().orderByDesc(App::getUpdateTime));
        return list.stream().map(app -> {
            AppVo appVo = app.toBean(AppVo.class);
            AppVersion appVersion = appVersionService.getById(app.getCurrentVersionId());
            appVo.setCurrentVersion(appVersion);
            return appVo;
        }).collect(Collectors.toList());
    }

    public AppVo selectById(int id) {
        App app = super.getById(id);
        if (app == null) {
            throw new MyException("未找到该app");
        }
        List<AppVersion> appVersions = appVersionService.selectByApp(id);
        AppVo appVo = app.toBean(AppVo.class);
        appVo.setVersions(appVersions);
        int downloadCount = appVersions.stream().mapToInt(AppVersion::getDownloadCount).sum();
        appVo.setDownloadCount(downloadCount);
        return appVo;
    }

    public App selectByPackageName(String packageName) {
        return super.getOne(new LambdaQueryWrapper<App>().eq(App::getPackageName, packageName));
    }

    public AppVersion selectLatestByPackageName(String packageName) {
        App app = selectByPackageName(packageName);
        AppVersion appVersion = appVersionService.getById(app.getCurrentVersionId());
        appVersion.setIcon(null);
        appVersion.setDownloadUrl("appVersions/downloadApk/" + app.getCurrentVersionId());
        return appVersion;
    }

    public void uploadApk(AppUploadVo appUploadVo, MultipartFile file) {
        if (!ObjectUtils.allNotNull(appUploadVo.getPackageName(), appUploadVo.getName(), appUploadVo.getVersionName(), appUploadVo.getVersionCode())) {
            throw new MyException("应用名、包名、版本不能为空");
        }
        //若没有app则新增
        App app = selectByPackageName(appUploadVo.getPackageName());
        if (app == null) {
            app = new App();
            app.setName(appUploadVo.getName());
            app.setPackageName(appUploadVo.getPackageName());
            app.setShortCode(RandomStringUtils.randomAlphabetic(4).toLowerCase());
            super.save(app);
        }
        //新增版本
        String filename = String.format("%s@%s_%s.apk", appUploadVo.getName(), appUploadVo.getVersionName(), RandomStringUtils.randomAlphabetic(5));
        AppVersion appVersion = appUploadVo.toBean(AppVersion.class);
        appVersion.setAppId(app.getId());
        appVersion.setSize(file.getSize() / 1024);
        appVersion.setDownloadUrl(filename);
        appVersionService.save(appVersion);
        //更新app中currentId
        app.setCurrentVersionId(appVersion.getId());
        super.updateById(app);
        storageService.store(file, filename);
    }

    public AppVo selectByShortCode(String shortCode) {
        App app = super.getOne(new LambdaQueryWrapper<App>().eq(App::getShortCode, shortCode));
        if ((app == null)) {
            throw new MyException("该app不存在");
        }
        AppVo appVo = app.toBean(AppVo.class);
        AppVersion appVersion = appVersionService.getById(app.getCurrentVersionId());
        appVo.setCurrentVersion(appVersion);
        return appVo;
    }
}
