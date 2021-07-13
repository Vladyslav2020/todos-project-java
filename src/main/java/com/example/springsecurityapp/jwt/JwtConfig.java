package com.example.springsecurityapp.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import javax.crypto.SecretKey;

@Configuration
public class JwtConfig {
    @Value("${app.jwt.secretKey}")
    private String secretKey;
    @Value("${app.jwt.tokenPrefix}")
    private String tokenPrefix;
    @Value("${app.jwt.expirationInDays}")
    private Integer expirationInDays;

    public JwtConfig() {
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public Integer getExpirationInDays() {
        return expirationInDays;
    }

    public void setExpirationInDays(Integer expirationInDays) {
        this.expirationInDays = expirationInDays;
    }

    public String getAuthorizationHearer(){
        return HttpHeaders.AUTHORIZATION;
    }
}
