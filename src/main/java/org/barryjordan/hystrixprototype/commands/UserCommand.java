package org.barryjordan.hystrixprototype.commands;

import org.barryjordan.hystrixprototype.model.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  Makes request to user service for user data.
 */
public class UserCommand extends HystrixCommand<User> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCommand.class);
    private final int userID;

    /**
     * Creates a new instance.
     *
     * @param userID To get User data for.
     */
    public UserCommand(final int userID) {
        super(HystrixCommandGroupKey.Factory.asKey("UserGroup"));
        this.userID = userID;
    }

    @Override
    protected User run() throws Exception {
        Thread.sleep(400);
        LOGGER.info(this.getClass().getSimpleName() + " : Thread ID " + Thread.currentThread().getId());
        return new User(userID, 1, "Barry");
    }
}
