package com.step.ap.controller;

import com.step.ap.config.annotation.NoAuth;
import com.step.ap.entity.App;
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
@RequestMapping("apps")
public class AppController {

    private final AppService appService;

    @ApiOperation("获取所有应用")
    @GetMapping
    public List<AppVo> getList() {
        return appService.getList();
    }

    @ApiOperation("获取单个数据")
    @GetMapping("{id}")
    public AppVo selectById(@PathVariable Integer id) {
        return appService.selectById(id);
    }

    @ApiOperation("创建")
    @PostMapping
    public void insert(@RequestBody App app) {
        appService.save(app);
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

    @NoAuth
    @ApiOperation("apk上传")
    @PostMapping("upload")
    public void uploadApk(AppUploadVo appUploadVo, @RequestParam MultipartFile file) {
        appService.uploadApk(appUploadVo, file);
    }
}
