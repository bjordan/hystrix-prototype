package org.barryjordan.hystrixprototype.service;

import org.barryjordan.hystrixprototype.commands.BalanceCommand;
import org.barryjordan.hystrixprototype.commands.FallbackCommand;
import org.barryjordan.hystrixprototype.commands.UserCommand;
import org.barryjordan.hystrixprototype.commands.UserLevelCommand;
import org.barryjordan.hystrixprototype.model.Balance;
import org.barryjordan.hystrixprototype.model.Profile;
import org.barryjordan.hystrixprototype.model.User;
import org.barryjordan.hystrixprototype.model.UserLevel;
import rx.Observable;

/**
 * ProfileService Implementation.
 *
 * Uses Hystrix to execute each "service call" in bulk heads (separate Thread pools),
 * returning an Observable in each case, and zipping to produce and single aggregated
 * profile object to return.
 */
public class ProfileServiceImpl implements ProfileService {
    @Override
    public Profile getProfile(int userID) {

        // get user (avatar, alias)
        Observable<User> commandUser = new UserCommand(userID).observe();
        // get balance (coin balance)
        Observable<Balance> commandBalance = new BalanceCommand(userID).observe();
        // get level (title, level, progress/total to next level)
        Observable<UserLevel> commandUserLevel = new UserLevelCommand(userID).observe();
        // not used - just example of when fallback method is executed
        Observable<String> commandFallback = new FallbackCommand().observe();

        return Observable.zip(
                commandUser, commandBalance, commandUserLevel,
                (User user, Balance balance, UserLevel userLevel) ->
                { return new Profile(user, balance, userLevel); }
        ).toBlocking().first();
    }
}
