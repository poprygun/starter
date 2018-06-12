package io.microsamples.ux.backend.holidays;

import com.holidaywebservice.holidayservice_v2.Country;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ScalarsTests {

    @Test
    public void givenDateShouldGenerateScalar(){
        log.info(Country.valueOf("UNITED_STATES").value());
    }
}
