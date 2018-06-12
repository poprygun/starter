package io.microsamples.ux.backend.holidays;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.holidaywebservice.holidayservice_v2.Country;
import com.holidaywebservice.holidayservice_v2.HolidayCode;
import com.holidaywebservice.holidayservice_v2.HolidayService2Soap;

import java.util.Date;
import java.util.List;

public class Query implements GraphQLQueryResolver {

    private HolidayService2Soap holidayService2Soap;

    public Query(HolidayService2Soap holidayService2Soap) {
        this.holidayService2Soap = holidayService2Soap;
    }

    public List<HolidayCode> holidaysByCountry(Country country) {
        return holidayService2Soap.getHolidaysAvailable(country).getHolidayCode();
    }

    public Date holidayDate(Country country, String holidayCode, int year){
        return holidayService2Soap.getHolidayDate(country, holidayCode, year).toGregorianCalendar().getTime();
    }
}
