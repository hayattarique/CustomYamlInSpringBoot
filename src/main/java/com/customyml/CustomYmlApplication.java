package com.customyml;

import com.customyml.beans.Tournament;
import com.customyml.factories.YmlPropertiesFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(name = "custom",value = "classpath:custom.yml",factory = YmlPropertiesFactory.class)
public class CustomYmlApplication {
    public static void main(String[] args) {

      //  ApplicationContext context = new SpringApplicationBuilder(CustomYmlApplication.class).initializers(new YmlConfigInitializer()).build().run(args);
        ApplicationContext context = SpringApplication.run(CustomYmlApplication.class, args);
         Tournament tournament = context.getBean(Tournament.class);
        System.out.println(tournament);
    }
}
