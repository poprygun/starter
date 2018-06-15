package io.microsamples.ux.backend.rest;

import io.microsamples.integrations.rest.api.MoviesApi;
import io.microsamples.integrations.rest.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RestTests {
    @Autowired
    private MoviesApi moviesApi;

    @Test
    public void givenMoviesServiceShouldLoadMovies() {
        String[] tags = {"one", "two", "three"};
        List<Movie> movies = moviesApi.findMovies(Arrays.asList(tags), 3);
        log.info(Arrays.toString(Arrays.asList(movies).toArray()));
    }
}
