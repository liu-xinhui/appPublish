package com.step.ap.vo;

import com.step.ap.entity.App;
import com.step.ap.entity.AppVersion;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AppVo extends App {
    private List<AppVersion> versions;
}
