## graphql-server

### Testing

Query Tests extend `WireMockServiceTests` class that loads stubs from `test\resources\mappings`.  

- Easiest way to test is to use a [GraphiQl](http://localhost:8080/graphiql)

```
query getCountryCodes($countryCode: String!, $year: Int!)
{
  holidayDate(countryCode: $countryCode, holidayCode: "THANKSGIVING", year: $year)

  holidaysByCountry(countryCode: $countryCode){
    code
    description
    holidayDate(countryCode: $countryCode, year: $year)
  }
}
```
Query Parameters
______
```
{
  "countryCode": "UNITED_STATES",
  "year": 2045
}
```

- [Use Postman to send queries to grapql](https://stackoverflow.com/questions/42520663/how-to-send-graphql-query-by-postman)

Sample query:
```json
{"query":"{holidaysByCountry(countryCode: \"UNITED_STATES\"){code description}}"}
```

- Or alternatively, use [graphql IDE](https://github.com/andev-software/graphql-ide)