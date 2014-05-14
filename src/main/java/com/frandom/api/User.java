package com.frandom.api;

import java.util.Set;

/**
 * Represents user.
 */
public interface User {

    /**
     * @return name to be displayed on chat.
     */
    String getDisplayName();

    /**
     * @return name of user.
     */
    String getName();

    /**
     * @return ID of user.
     */
    String getID();

    /**
     * @return facebook user id.
     */
    String getFbID();

    /**
     * @return email id of user.
     */
    String getEmailID();

    /**
     * @return facebook user IDs of friends.
     */
    Set<String> getFBFriendsIDs();

    /**
     * @return user IDs of friends.
     */
    Set<String> getFriendsIDs();

    /**
     * @param user {@link User}
     * @return true if this is friend of passed user.
     */
    boolean isFriendsWith(User user);

}
