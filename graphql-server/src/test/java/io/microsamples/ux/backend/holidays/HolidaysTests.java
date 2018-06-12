package io.microsamples.ux.backend.holidays;

import com.holidaywebservice.holidayservice_v2.ArrayOfHolidayCode;
import com.holidaywebservice.holidayservice_v2.Country;
import com.holidaywebservice.holidayservice_v2.HolidayService2Soap;
import io.microsamples.integrations.soap.WireMockServiceTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HolidaysTests extends WireMockServiceTests {

    @Autowired
    private HolidayService2Soap holidayService2Soap;

    @Test
    public void givenStarterProjectShouldLoadHolidaysService() {
        ArrayOfHolidayCode holidaysAvailable = holidayService2Soap.getHolidaysAvailable(Country.UNITED_STATES);
        assertThat(holidaysAvailable.getHolidayCode(), is(not(empty())));
    }
}
