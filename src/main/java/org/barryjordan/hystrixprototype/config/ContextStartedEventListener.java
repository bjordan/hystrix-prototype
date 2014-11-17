package org.barryjordan.hystrixprototype.config;

import com.netflix.hystrix.strategy.HystrixPlugins;
import org.barryjordan.hystrixprototype.eventnotifier.LogEventNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Code to execute on Application Context startup/refresh.
 */
public class ContextStartedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContextStartedEventListener.class);
    private boolean initialized = false;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (!initialized) {
            LOGGER.info("Registering Hystrix Event Notifier");
            HystrixPlugins.getInstance().registerEventNotifier(LogEventNotifier.getInstance());
            initialized = true;
        }
    }
}
