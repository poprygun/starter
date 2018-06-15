import React from 'react'
import { graphql } from 'react-apollo'
import gql from 'graphql-tag'

import { AgGridReact } from 'ag-grid-react';
import 'ag-grid/dist/styles/ag-grid.css';
import 'ag-grid/dist/styles/ag-theme-balham.css';

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
    this.state = {
        columnDefs: [
            {headerName: "Code", field: "code"},
            {headerName: "Description", field: "description"},
            {headerName: "Date", field: "date"}

        ],
        rowData: data.holidaysByCountry.map((item => (
            {code: item.code, description: item.description, date: item.holidayDate}
        )))
    }
    return (
      <div className="ag-theme-balham"
           style={{
             height: '500px',
             width: '600px' }}>
        <AgGridReact
          enableSorting={true}
          enableFilter={true}
          columnDefs={this.state.columnDefs}
          rowData={this.state.rowData}>
        </AgGridReact>
      </div>
    )
  }
}

HomeView = graphql(query)(HomeView)

export default HomeView