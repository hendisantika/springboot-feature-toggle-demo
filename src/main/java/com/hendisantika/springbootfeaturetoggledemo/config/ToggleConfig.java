package com.hendisantika.springbootfeaturetoggledemo.config;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.user.NoOpUserProvider;
import org.togglz.core.user.UserProvider;
import org.togglz.mongodb.MongoStateRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-feature-toggle-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-05-30
 * Time: 07:14
 */
@Configuration
public class ToggleConfig {
    private static final String FEATURE_TOGGLE_TABLE = "feature_toggle_table";


    @Autowired
    private MongoClient mongoClient;

    @Bean
    public UserProvider userProvider() {
        return new NoOpUserProvider();
    }

    @Bean
    public StateRepository getStateRepository() {

        StateRepository repository = MongoStateRepository
                .newBuilder(mongoClient, "feature-toggle")
                .collection(FEATURE_TOGGLE_TABLE)
                //.authentication("john", "tiger")
                .writeConcern(WriteConcern.W1)
                .build();

        return repository;
    }
}