package com.udacity.builditbigger.backend;

import com.example.Joker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeBeanApi",
        version = "v1",
        resource = "jokeBean",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.udacity.com",
                ownerName = "backend.builditbigger.udacity.com",
                packagePath = ""
        )
)
public class JokeBeanEndpoint {

    private static final Logger logger = Logger.getLogger(JokeBeanEndpoint.class.getName());

    @ApiMethod(name = "serveJokes")
    public JokeBean serveJokes(){
        JokeBean response = new JokeBean();
        Joker joker = new Joker();
        List<String> jokeList = joker.getJokeList();
        Random random = new Random();
        int random_index = random.nextInt(10);
        String random_joke = jokeList.get(random_index);
        response.setJoke(random_joke);
        return response;
    }

}