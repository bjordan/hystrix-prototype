package org.barryjordan.hystrixprototype.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates use of fallback when run()
 * throws an exception.
 */
public class FallbackCommand extends HystrixCommand<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FallbackCommand.class);

    /**
     * Creates a new instance.
     */
    public FallbackCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("UserGroup"));
    }

    @Override
    protected String run() throws Exception {
        // Thread execution timeout is set to 1000 so this will trigger an Exception.
        Thread.sleep(1500);
        LOGGER.info(this.getClass().getSimpleName() + " : Thread ID " + Thread.currentThread().getId());
        return "FallbackCommand run";
    }

    @Override
    protected String getFallback() {
        return "FallbackCommand getFallback";
    }
}
