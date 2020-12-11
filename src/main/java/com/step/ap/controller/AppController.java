package com.step.ap.controller;

import com.step.ap.config.annotation.NoAuth;
import com.step.ap.entity.App;
import com.step.ap.entity.AppVersion;
import com.step.ap.service.AppService;
import com.step.ap.vo.AppUploadVo;
import com.step.ap.vo.AppVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api("应用")
@AllArgsConstructor
@RestController
@RequestMapping("api/apps")
public class AppController {

    private final AppService appService;

    @ApiOperation("获取所有应用")
    @GetMapping
    public List<AppVo> getList() {
        return appService.getList();
    }

    @ApiOperation("根据id获取详情")
    @GetMapping("{id}")
    public AppVo selectById(@PathVariable Integer id) {
        return appService.selectById(id);
    }

    @NoAuth
    @ApiOperation("根据shortCode获取详情")
    @GetMapping("shortCode/{shortCode}")
    public AppVo selectByShortCode(@PathVariable String shortCode) {
        return appService.selectByShortCode(shortCode);
    }

    @ApiOperation("编辑")
    @PutMapping
    public void updateById(@RequestBody App app) {
        appService.updateById(app);
    }

    @ApiOperation("删除")
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        appService.removeById(id);
    }

    @ApiOperation("apk上传")
    @PostMapping("upload")
    public void uploadApk(AppUploadVo appUploadVo, @RequestParam MultipartFile file) {
        appService.uploadApk(appUploadVo, file);
    }

    @NoAuth
    @ApiOperation("根据包名获取最新版本")
    @GetMapping("latest/{packageName}")
    public AppVersion selectLatestByPackageName(@PathVariable String packageName) {
        return appService.selectLatestByPackageName(packageName);
    }
}
