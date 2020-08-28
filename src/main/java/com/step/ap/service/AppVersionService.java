package com.step.ap.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.step.ap.base.BaseService;
import com.step.ap.entity.AppVersion;
import lombok.AllArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

/**
 * 服务类
 */
@Service
@Transactional
@AllArgsConstructor
public class AppVersionService extends BaseService<AppVersion> {

    public List<AppVersion> selectByApp(Integer appId) {
        return super.list(new LambdaQueryWrapper<AppVersion>()
                .eq(AppVersion::getAppId, appId)
                .orderByDesc(AppVersion::getCreateTime)
        );
    }

    public ResponseEntity<Resource> downloadApk(Integer versionId) {
        AppVersion appVersion = super.getById(versionId);
        String filename = appVersion.getDownloadUrl();
        String fileNameEncode = new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        FileSystemResource file = new FileSystemResource(Paths.get(FileSystemStorageService.FILE_PATH, filename));
        //保存下载次数
        AppVersion appVersionNew = new AppVersion();
        appVersionNew.setId(appVersion.getId());
        appVersionNew.setDownloadCount(appVersion.getDownloadCount() + 1);
        super.updateById(appVersionNew);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileNameEncode)
                .header(HttpHeaders.CONTENT_TYPE,"application/vnd.android.package-archive")
                .body(file);
    }
}
