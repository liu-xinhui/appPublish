package com.step.ap.controller;

import com.step.ap.config.AppConfig;
import com.step.ap.config.annotation.NoAuth;
import com.step.ap.exception.MyException;
import com.step.ap.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "认证")
@AllArgsConstructor
@RestController
@RequestMapping("account")
public class AccountController {
    private final AppConfig config;

    @NoAuth
    @ApiOperation("登录")
    @GetMapping("login")
    public Map<String, Object> login(@RequestParam @ApiParam(value = "账号", required = true) String username,
                                     @RequestParam @ApiParam(value = "密码", required = true) String password) {
        if (config.getUsername().equals(username) && config.getPassword().equals(password)) {
            Map<String, Object> result = new HashMap<>();
            result.put("username", username);
            result.put("token", JwtUtil.createToken());
            return result;
        } else {
            throw new MyException("账号或密码错误");
        }
    }
}
