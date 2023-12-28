package com.customyml.initializer;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

import java.io.IOException;
import java.util.List;

public class YmlConfigInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    //@SneakyThrows
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        try {
            YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
            List<PropertySource<?>> propertySources = loader.load("own_config", applicationContext.getResource("classpath:custom.yml"));
            ConfigurableEnvironment environment = applicationContext.getEnvironment();
            propertySources.forEach(propertySource -> {
                environment.getPropertySources().addLast(propertySource);
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
