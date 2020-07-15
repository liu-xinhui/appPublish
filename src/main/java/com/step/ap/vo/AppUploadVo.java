package com.step.ap.vo;

import com.step.ap.entity.AppVersion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUploadVo extends AppVersion {
    private String packageName;
}
