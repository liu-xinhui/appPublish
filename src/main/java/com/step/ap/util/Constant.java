package com.step.ap.util;

import lombok.Getter;

public class Constant {
    /**
     * 默认分页大小,字符串类型
     */
    public static final String PAGE_SIZE = "15";

    /**
     * 认证请求头名称
     */
    public static final String AUTHORIZATION = "Authorization";

    /**
     * 用户状态
     */
    public enum UserStatus {
        disabled("禁用"), enabled("启用");
        @Getter
        private final String desc;

        UserStatus(String desc) {
            this.desc = desc;
        }
    }
}
