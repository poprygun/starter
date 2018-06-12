package io.microsamples.ux.backend.holidays;

import io.microsamples.integrations.soap.WireMockServiceTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HolidaysQueryTests extends WireMockServiceTests {

    @LocalServerPort
    int port;

    @Test
    public void givenHolidaysQueryShouldReturnCountryHolidays() {
        given().port(port).basePath("/graphql")
                .log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body("{\"query\":\"\\nquery getCountryCodes($countryCode: String!, $year: Int!)\\n{\\n  holidayDate(countryCode: $countryCode, holidayCode: \\\"THANKSGIVING\\\", year: $year)\\n\\n  holidaysByCountry(countryCode: $countryCode){\\n    code\\n    description\\n    holidayDate(countryCode: $countryCode, year: $year)\\n  }\\n}\",\"variables\":{\"countryCode\":\"UNITED_STATES\",\"year\":2018},\"operationName\":\"getCountryCodes\"}")
                .post()
                .then()
                .log().all()
                .statusCode(200)
                .and()
                .assertThat()
                .body("data", is(not(isEmptyString())))
                .body("data.holidaysByCountry[0].holidayDate", is(not(isEmptyString())))
                .body("data.holidaysByCountry.size()", equalTo(34));
    }
}
