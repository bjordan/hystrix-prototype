package org.barryjordan.hystrixprototype.model;

/**
 *  Represents a Users level.
 */
public final class UserLevel {
    private final int userID;
    private final int levelID;
    private final String levelTitle;
    private final int currentLevelProgress;
    private final int currentLevelGoal;

    /**
     * Creates a new instance.
     *
     * @param userID The users unique ID.
     * @param levelID The users current global level.
     * @param levelTitle The title associated with the global level.
     * @param currentLevelProgress Progress made in the current level, levelID.
     * @param currentLevelGoal The figure to reach to complete level.
     */
    public UserLevel(
            final int userID,
            final int levelID,
            final String levelTitle,
            final int currentLevelProgress,
            final int currentLevelGoal) {
        this.userID = userID;
        this.levelID = levelID;
        this.levelTitle = levelTitle;
        this.currentLevelProgress = currentLevelProgress;
        this.currentLevelGoal = currentLevelGoal;
    }

    public int getUserID() {
        return userID;
    }

    public int getLevelID() {
        return levelID;
    }

    public String getLevelTitle() {
        return levelTitle;
    }

    public int getCurrentLevelProgress() {
        return currentLevelProgress;
    }

    public int getCurrentLevelGoal() {
        return currentLevelGoal;
    }
}
