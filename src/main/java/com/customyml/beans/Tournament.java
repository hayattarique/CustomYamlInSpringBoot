package com.customyml.beans;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "t")
@Component
public class Tournament {
    private int id;
    private String participatingTeam;
    private String host;
    private int duration;
}
