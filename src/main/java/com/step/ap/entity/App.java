package com.step.ap.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.step.ap.base.BaseLogEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("应用列表")
@Getter
@Setter
@TableName("app")
public class App extends BaseLogEntity {

    @ApiModelProperty("应用名称")
    private String name;

    @ApiModelProperty("包名")
    private String packageName;

    @ApiModelProperty("短链接")
    private String shortCode;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("当前的版本id")
    private Integer currentVersionId;

    @ApiModelProperty("当前的版本code")
    private Integer currentVersionCode;

    @ApiModelProperty("当前的版本name")
    private String currentVersionName;
}
