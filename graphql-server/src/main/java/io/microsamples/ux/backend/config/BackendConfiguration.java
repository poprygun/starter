package io.microsamples.ux.backend.config;

import com.holidaywebservice.holidayservice_v2.HolidayService2Soap;
import io.microsamples.integrations.rest.api.MoviesApi;
import io.microsamples.ux.backend.holidays.HolydayResolver;
import io.microsamples.ux.backend.holidays.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackendConfiguration {
    @Bean
    public Query query(HolidayService2Soap holidayService, MoviesApi moviesApi) {
        return new Query(holidayService, moviesApi);
    }

    @Bean
    public HolydayResolver holidayResolver(HolidayService2Soap holidayService) {
        return new HolydayResolver(holidayService);
    }
}
