package com.step.ap.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("ap")
public class AppConfig {
    private String username;
    private String password;
}
