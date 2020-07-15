package com.step.ap.svo;

import com.step.ap.base.BaseSvo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSvo extends BaseSvo {

    @ApiModelProperty("搜索-账号")
    private String username;
}
