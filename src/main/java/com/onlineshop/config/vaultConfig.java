package com.onlineshop.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Configuration
@ConfigurationProperties("vault")
public class vaultConfig {

    private String username;
    private String password;
}
