package com.example.shani.myapplication.backend;

import com.example.Joker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeBeanApi",
        version = "v1",
        resource = "jokeBean",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.shani.example.com",
                ownerName = "backend.myapplication.shani.example.com",
                packagePath = ""
        )
)
public class JokeBeanEndpoint {

    private static final Logger logger = Logger.getLogger(JokeBeanEndpoint.class.getName());



    @ApiMethod(name = "getJoke")
    public JokeBean getJoke(){
        JokeBean jokeBean = new JokeBean();
        Joker joker = new Joker();
        List<String> jokeList = joker.getJokeList();
        Random random = new Random();
        int random_index = random.nextInt(10);
        String random_joke = jokeList.get(random_index);
        jokeBean.setJoke(random_joke);
        return jokeBean;
    }

    /**
     * This method gets the <code>JokeBean</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>JokeBean</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getJokeBean")
    public JokeBean getJokeBean(@Named("id") Long id) {
        // TODO: Implement this function
        logger.info("Calling getJokeBean method");
        return null;
    }

    /**
     * This inserts a new <code>JokeBean</code> object.
     *
     * @param jokeBean The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertJokeBean")
    public JokeBean insertJokeBean(JokeBean jokeBean) {
        // TODO: Implement this function
        logger.info("Calling insertJokeBean method");
        return jokeBean;
    }

}