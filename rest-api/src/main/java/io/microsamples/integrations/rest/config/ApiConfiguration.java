package io.microsamples.integrations.rest.config;

import io.microsamples.integrations.rest.ApiClient;
import io.microsamples.integrations.rest.api.MoviesApi;
import io.microsamples.integrations.rest.auth.OAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiConfiguration {

    @Bean
    public MoviesApi moviesApi(ApiClient apiClient){
        return new MoviesApi(apiClient);
    }

    @Bean
    public ApiClient apiClient(@Value("${movies.baseUrl:http://localhost:3333/movies}")
                               String baseUrl){
        ApiClient apiClient = new ApiClient();

        apiClient.setBasePath(baseUrl);

        //in case auth is needed...
//        OAuth petStoreAuth = (OAuth) apiClient.getAuthentication("petstore_auth");
//        petStoreAuth.setAccessToken("special-key");

        return apiClient;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
