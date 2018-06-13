import React, { Component } from 'react'
// apollo imports
import ApolloClient from 'apollo-client';
import { HttpLink } from 'apollo-link-http';
import { InMemoryCache } from 'apollo-cache-inmemory'
import { ApolloProvider } from 'react-apollo';
import { BrowserRouter as Router, Route } from 'react-router-dom'
import HomeView from './views/HomeView'

var linkUri = process.env.REACT_APP_LINK_URI || 'http://localhost:8080/graphql'
console.log('Using graphQL server:', linkUri)

const client =  new ApolloClient({
  link: new HttpLink({ uri: linkUri}),
  cache: new InMemoryCache().restore(window.__APOLLO_STATE__),
});

class App extends Component {
  render() {
    return (
      <ApolloProvider client={client}>
        <Router>
          <div>
            <Route exact path="/" component={HomeView} />
          </div>
        </Router>
      </ApolloProvider>
    )
  }
}

export default App