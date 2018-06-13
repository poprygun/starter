# Sample project to demo GraphQl + Spring Boot + Soap Integration.

Example use of GraphQL, ReactJs, and CXF using [Holidays SOAP API](http://www.holidaywebservice.com/ServicesAvailable_USHolidayService.aspx) to render holidays data. 

## Modules description

### frontend

Bootstrap react app

```bash
npm install -g create-react-app
create-react-app frontend
yarn add react-router-dom
yarn add react-apollo
```

Looks like few more packages are needed for Apollo 2

```bash
npm i --save apollo-client@next apollo-cache-inmemory@next apollo-link-http
```

### holidays

Module is implemented as a Spring Boot autoconfiguration module.
Soap Integration is using [Apache CXF](http://cxf.apache.org/)

### graphql-server

Enable soap message logging with setting `integrations.holidays.enableMessageLogging=true`





        
                 