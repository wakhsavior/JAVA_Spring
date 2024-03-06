package ru.gb.MyRickAndMortyAPI.configs;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "application")
@Configuration
@Data
public class ConfigCustomer {
    private String restURL;
}
