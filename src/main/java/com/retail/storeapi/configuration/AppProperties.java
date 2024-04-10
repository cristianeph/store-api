package com.retail.storeapi.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties("app")
@Data
public class AppProperties {
    private Cors cors;

    @Data
    public static class Cors {
        private String allowOrigin;
        private String allowCredentials;
    }
}
