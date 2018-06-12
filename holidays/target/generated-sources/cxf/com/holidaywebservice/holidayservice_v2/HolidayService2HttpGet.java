package com.holidaywebservice.holidayservice_v2;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-06-12T14:13:29.346-04:00
 * Generated source version: 3.2.4
 *
 */
@WebService(targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/", name = "HolidayService2HttpGet")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface HolidayService2HttpGet {

    /**
     * Get the holidays for a date range.
     */
    @WebMethod(operationName = "GetHolidaysForDateRange")
    @WebResult(name = "ArrayOfHoliday", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/", partName = "Body")
    public ArrayOfHoliday getHolidaysForDateRange(
        @WebParam(partName = "countryCode", name = "countryCode", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/")
        java.lang.String countryCode,
        @WebParam(partName = "startDate", name = "startDate", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/")
        java.lang.String startDate,
        @WebParam(partName = "endDate", name = "endDate", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/")
        java.lang.String endDate
    );

    /**
     * Get the holidays for an entire year.
     */
    @WebMethod(operationName = "GetHolidaysForYear")
    @WebResult(name = "ArrayOfHoliday", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/", partName = "Body")
    public ArrayOfHoliday getHolidaysForYear(
        @WebParam(partName = "countryCode", name = "countryCode", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/")
        java.lang.String countryCode,
        @WebParam(partName = "year", name = "year", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/")
        java.lang.String year
    );

    /**
     * Get the holidays for a specific month.
     */
    @WebMethod(operationName = "GetHolidaysForMonth")
    @WebResult(name = "ArrayOfHoliday", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/", partName = "Body")
    public ArrayOfHoliday getHolidaysForMonth(
        @WebParam(partName = "countryCode", name = "countryCode", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/")
        java.lang.String countryCode,
        @WebParam(partName = "year", name = "year", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/")
        java.lang.String year,
        @WebParam(partName = "month", name = "month", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/")
        java.lang.String month
    );

    /**
     * Get the available countries.
     */
    @WebMethod(operationName = "GetCountriesAvailable")
    @WebResult(name = "ArrayOfCountryCode", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/", partName = "Body")
    public ArrayOfCountryCode getCountriesAvailable();

    /**
     * Get the date of a specific holiday.
     */
    @WebMethod(operationName = "GetHolidayDate")
    @WebResult(name = "dateTime", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/", partName = "Body")
    public javax.xml.datatype.XMLGregorianCalendar getHolidayDate(
        @WebParam(partName = "countryCode", name = "countryCode", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/")
        java.lang.String countryCode,
        @WebParam(partName = "holidayCode", name = "holidayCode", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/")
        java.lang.String holidayCode,
        @WebParam(partName = "year", name = "year", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/")
        java.lang.String year
    );

    /**
     * Get the available holidays for a specified country.
     */
    @WebMethod(operationName = "GetHolidaysAvailable")
    @WebResult(name = "ArrayOfHolidayCode", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/", partName = "Body")
    public ArrayOfHolidayCode getHolidaysAvailable(
        @WebParam(partName = "countryCode", name = "countryCode", targetNamespace = "http://www.holidaywebservice.com/HolidayService_v2/")
        java.lang.String countryCode
    );
}
