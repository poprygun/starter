package io.microsamples.ux.backend.holidays;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.holidaywebservice.holidayservice_v2.Country;
import com.holidaywebservice.holidayservice_v2.HolidayCode;
import com.holidaywebservice.holidayservice_v2.HolidayService2Soap;

import java.util.Date;

public class HolydayResolver implements GraphQLResolver<HolidayCode> {

    private HolidayService2Soap holidayService2Soap;

    public HolydayResolver(HolidayService2Soap holidayService2Soap) {
        this.holidayService2Soap = holidayService2Soap;
    }

    public Date holidayDate(HolidayCode holidayCode, String country, int year){
        return holidayService2Soap.getHolidayDate(Country.valueOf(country)
                , holidayCode.getCode(), year).toGregorianCalendar().getTime();
    }
}
