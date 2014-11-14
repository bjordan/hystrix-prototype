package org.barryjordan.hystrixprototype.model;

/**
 * Represents an immutable User.
 */
public final class User {
    private final int userID;
    private final int avatarID;
    private final String alias;

    /**
     * Creates a new instance.
     *
     * @param userID The users unique ID.
     * @param avatarID The users unique avatar ID.
     * @param alias The users alias.
     */
    public User(final int userID, final int avatarID, final String alias) {
        this.userID = userID;
        this.avatarID = avatarID;
        this.alias = alias;
    }

    public int getUserID() {
        return userID;
    }

    public int getAvatarID() {
        return avatarID;
    }

    public String getAlias() {
        return alias;
    }
}
