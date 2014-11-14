package org.barryjordan.hystrixprototype.config;

import org.barryjordan.hystrixprototype.controller.ProfileController;
import org.barryjordan.hystrixprototype.service.ProfileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Spring Servlet configuration.
 */
@EnableWebMvc
@Configuration
public class ServletConfig {
    @Bean
    public ProfileController profileController(final ProfileService profileService) {
        return new ProfileController(profileService);
    }
}
