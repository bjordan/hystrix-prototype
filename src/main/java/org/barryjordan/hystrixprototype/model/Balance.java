package org.barryjordan.hystrixprototype.model;

/**
 * Represents an immutable users coin balance;
 */
public final class Balance {
    private final int userID;
    private final int balance;

    /**
     * Creates a new instance.
     *
     * @param userID The Users unique ID.
     * @param balance Balance in cents.
     */
    public Balance(int userID, int balance) {
        this.userID = userID;
        this.balance = balance;
    }

    public int getUserID() {
        return userID;
    }

    public int getBalance() {
        return balance;
    }
}
