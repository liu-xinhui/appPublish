package com.step.ap.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.step.ap.base.BaseService;
import com.step.ap.entity.AppVersion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
