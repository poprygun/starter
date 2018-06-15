package io.microsamples.ux.backend.holidays;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.holidaywebservice.holidayservice_v2.Country;
import com.holidaywebservice.holidayservice_v2.HolidayCode;
import com.holidaywebservice.holidayservice_v2.HolidayService2Soap;
import io.microsamples.integrations.rest.api.MoviesApi;
import io.microsamples.integrations.rest.model.Movie;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Query implements GraphQLQueryResolver {

    private HolidayService2Soap holidayService2Soap;

    private MoviesApi moviesApi;

    public Query(HolidayService2Soap holidayService2Soap, MoviesApi moviesApi) {
        this.holidayService2Soap = holidayService2Soap;
        this.moviesApi = moviesApi;
    }

    public List<Movie> movies(){
        String[] tags = {"one", "two", "three"};
        List<Movie> movies = moviesApi.findMovies(Arrays.asList(tags), 3);
        return movies;
    }

    public List<HolidayCode> holidaysByCountry(Country country) {
        return holidayService2Soap.getHolidaysAvailable(country).getHolidayCode();
    }

    public Date holidayDate(Country country, String holidayCode, int year){
        return holidayService2Soap.getHolidayDate(country, holidayCode, year).toGregorianCalendar().getTime();
    }
}
