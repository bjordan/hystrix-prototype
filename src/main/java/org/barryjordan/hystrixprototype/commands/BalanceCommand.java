package org.barryjordan.hystrixprototype.commands;

import org.barryjordan.hystrixprototype.model.Balance;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Makes request to Balance service for user balance.
 */
public class BalanceCommand extends HystrixCommand<Balance> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BalanceCommand.class);
    private final int userID;

    /**
     * Creates a new instance.
     *
     * @param userID To get Balance data for.
     */
    public BalanceCommand(final int userID) {
        super(HystrixCommandGroupKey.Factory.asKey("BalanceGroup"));
        this.userID = userID;
    }

    @Override
    protected Balance run() throws Exception {
        Thread.sleep(200);
        LOGGER.info(this.getClass().getSimpleName() + " : Thread ID " + Thread.currentThread().getId());
        return new Balance(userID, 122222);
    }
}
