package org.barryjordan.hystrixprototype.model;

/**
 * Represents an immutable users profile.
 */
public final class Profile {
    private final User user;
    private final Balance balance;
    private final UserLevel userLevel;

    /**
     * Creates a new instance.
     *
     * @param user The user data..
     * @param balance The balance data.
     * @param userLevel The users level data.               .
     */
    public Profile(final User user, final Balance balance, final UserLevel userLevel) {
        this.user = user;
        this.balance = balance;
        this.userLevel = userLevel;
    }

    public User getUser() {
        return user;
    }

    public Balance getBalance() {
        return balance;
    }

    public UserLevel getUserLevel() {
        return userLevel;
    }
}
