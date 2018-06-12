package io.microsamples.integrations.soap;

import io.microsamples.integrations.soap.config.HolidaysClientAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@TestConfiguration
@PropertySources({
        @PropertySource("classpath:application.properties")
})
@Import({HolidaysClientAutoConfiguration.class})
public class TestConfig {
}
