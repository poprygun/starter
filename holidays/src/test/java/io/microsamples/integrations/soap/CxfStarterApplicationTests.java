package io.microsamples.integrations.soap;

import com.holidaywebservice.holidayservice_v2.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.datatype.XMLGregorianCalendar;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
        TestConfig.class
})
public class CxfStarterApplicationTests extends WireMockServiceTests{

    @Autowired
    private HolidayService2Soap holidayService2Soap;

    @Test
    public void shouldCallHolidayDate(){
        final String[] holidayCodes = {"NEW-YEARS-DAY-ACTUAL"
                , "NEW-YEARS-DAY-OBSERVED"
                , "MARTIN-LUTHER-KING-BIRTHDAY-ACTUAL"
                , "MARTIN-LUTHER-KING-BIRTHDAY-OBSERVED"
                , "GROUNDHOG-DAY"
                , "LINCOLN-BIRTHDAY"
                , "VALENTINES-DAY"
                , "WASHINGTON-BIRTHDAY"
                , "PRESIDENTS-DAY"
                , "EASTER"
                , "GOOD-FRIDAY"
                , "SHROVE-TUESDAY"
                , "ASH-WEDNESDAY"
                , "ST-PATRICKS-DAY"
                , "APRIL-FOOLS"
                , "EARTH-DAY"
                , "MOTHERS-DAY"
                , "MEMORIAL-DAY"
                , "CINCO-DE-MAYO"
                , "FATHERS-DAY"
                , "FLAG-DAY"
                , "INDEPENDENCE-DAY-ACTUAL"
                , "INDEPENDENCE-DAY-OBSERVED"
                , "LABOR-DAY"
                , "PATRIOT-DAY"
                , "COLUMBUS-DAY"
                , "HALLOWEEN"
                , "VETERANS-DAY-ACTUAL"
                , "VETERANS-DAY-OBSERVED"
                , "THANKSGIVING"
                , "BLACK-FRIDAY"
                , "CHRISTMAS-ACTUAL"
                , "CHRISTMAS-OBSERVED"
                , "NEW-YEARS-EVE"};

        for (String code :
                holidayCodes) {
            XMLGregorianCalendar holidayDate = holidayService2Soap.getHolidayDate(Country.UNITED_STATES, code, 2018);
            assertThat(holidayDate, is(notNullValue()));
        }

    }

    @Test
    public void shouldCallWithoutSpringBoot(){
        HolidayService2 holidayService = new HolidayService2();
        HolidayService2Soap holidayService2Soap = holidayService.getHolidayService2Soap();

        ArrayOfHolidayCode holidaysAvailable = holidayService2Soap.getHolidaysAvailable(Country.UNITED_STATES);
        assertThat(holidaysAvailable, is(notNullValue()));
    }


    @Test
    public void shouldCallWeatherServiceUsingBootService() {
        ArrayOfHolidayCode holidaysAvailable = holidayService2Soap.getHolidaysAvailable(Country.UNITED_STATES);
        assertThat(holidaysAvailable, is(notNullValue()));
    }

}
