package org.barryjordan.hystrixprototype.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 *
 */
public class ContextStartedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContextStartedEventListener.class);

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        LOGGER.info("Registering Hystrix Event Notifier");
        //HystrixPlugins.getInstance().registerEventNotifier(LogEventNotifier.getInstance());
    }
}
