package org.barryjordan.hystrixprototype.config;

import org.barryjordan.hystrixprototype.service.ProfileService;
import org.barryjordan.hystrixprototype.service.ProfileServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Context configuration.
 */
@Configuration
public class ContextConfig {

    @Bean
    public ProfileService profileService() {
        return new ProfileServiceImpl();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public ContextStartedEventListener contextStartedEventListener() {
        return new ContextStartedEventListener();
    }
}
