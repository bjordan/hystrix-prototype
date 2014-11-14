package org.barryjordan.hystrixprototype.commands;

import org.barryjordan.hystrixprototype.model.UserLevel;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  Makes request to user level service for user level data.
 */
public class UserLevelCommand extends HystrixCommand<UserLevel> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLevelCommand.class);
    private final int userID;

    /**
     * Creates a new instance.
     *
     * @param userID To get User level data for.
     */
    public UserLevelCommand(final int userID) {
        super(HystrixCommandGroupKey.Factory.asKey("LevelGroup"));
        this.userID = userID;
    }

    @Override
    protected UserLevel run() throws Exception {
        Thread.sleep(300);
        LOGGER.info(this.getClass().getSimpleName() + " : Thread ID " + Thread.currentThread().getId());
        return new UserLevel(userID, 1, "First Level", 20, 100);
    }
}
