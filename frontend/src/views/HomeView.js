import React from 'react'
import { Link } from 'react-router-dom'
import { graphql } from 'react-apollo'
import gql from 'graphql-tag'

const query = gql `{
    holidaysByCountry(countryCode: "UNITED_STATES"){
      code
      description    
        holidayDate(countryCode: "UNITED_STATES", year: 2018)
    }
  }`

class HomeView extends React.Component {
  render() {
    let { data } = this.props
    if (data.loading) {
      return <div>Loading...</div>
    }
    return (
      <div>
        {data.holidaysByCountry.map((item, index) => (
          <p key={item.code}>
              {item.description} {item.holidayDate}
          </p>
        ))}
      </div>
    )
  }
}

HomeView = graphql(query)(HomeView)

export default HomeView