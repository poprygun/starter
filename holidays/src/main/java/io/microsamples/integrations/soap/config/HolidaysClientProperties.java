package io.microsamples.integrations.soap.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "integrations.holidays")
@Getter
@Setter
public class HolidaysClientProperties {
    private String serviceAddress;
    private boolean enableMessageLogging;
}
