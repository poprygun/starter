## graphql-server

### Testing

Query Tests extend `WireMockServiceTests` class that loads stubs from `test\resources\mappings`.  

- Easiest way to test is to use a [GraphiQl](http://localhost:8080/graphiql)

```
{
  holidaysByCountry(countryCode: "UNITED_STATES"){
    code
    description
  }
}


query getCountryCodes($countryCode: String!)
{
  holidayDate(countryCode: "UNITED_STATES", holidayCode: "THANKSGIVING", year: 2018)

  holidaysByCountry(countryCode: $countryCode){
    code
    description    
  }
}

{
  "countryCode":"UNITED_STATES"
}
```

- [Use Postman to send queries to grapql](https://stackoverflow.com/questions/42520663/how-to-send-graphql-query-by-postman)

Sample query:
```json
{"query":"{holidaysByCountry(countryCode: \"UNITED_STATES\"){code description}}"}
```

- Or alternatively, use [graphql IDE](https://github.com/andev-software/graphql-ide)