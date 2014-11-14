package org.barryjordan.hystrixprototype.eventnotifier;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixEventType;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *  Custom HystrixEventNotifier that simply logs event data.
 */
public class LogEventNotifier extends HystrixEventNotifier {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogEventNotifier.class);
    private static final HystrixEventNotifier INSTANCE = new LogEventNotifier();

    private LogEventNotifier() {
    }

    public static HystrixEventNotifier getInstance() {
        return INSTANCE;
    }

    @Override
    public void markEvent(final HystrixEventType eventType, final HystrixCommandKey key) {
        LOGGER.info(String.format("Key Name %s, eventType %s", key.name(), eventType.toString()));
    }

    @Override
    public void markCommandExecution(
            final HystrixCommandKey key,
            final HystrixCommandProperties.ExecutionIsolationStrategy isolationStrategy,
            final int duration,
            final List<HystrixEventType> eventsDuringExecution) {
        LOGGER.info(String.format("Key Name %s, duration %d", key.name(), duration));

        for (HystrixEventType hystrixEventType : eventsDuringExecution) {
            LOGGER.info(String.format("Event Type %s", hystrixEventType.toString()));
        }
    }
}
