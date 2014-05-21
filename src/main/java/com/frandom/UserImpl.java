package com.frandom;

import com.frandom.api.User;

import java.util.HashSet;
import java.util.Set;

/**
 * user impl.
 */
public class UserImpl implements User{

    private final String displayName;
    private final String name;
    private final String id;
    private final String fbId;
    private final String emailId;
    private final Set<String> friendIDs;
    private final Set<String> fbFriendIDs;

    @Override
    public boolean isFriendsWith(User user) {
        return friendIDs.contains(user.getID()) && fbFriendIDs.contains(user.getFbID());
    }

    public UserImpl(String displayName, String name, String id, String fbId, String emailId, Set<String> friendIDs,
                    Set<String> fbFriendIDs) {
        this.displayName = displayName;
        this.name = name;
        this.id = id;
        this.fbId = fbId;
        this.emailId = emailId;
        this.friendIDs = new HashSet<String>(friendIDs);
        this.fbFriendIDs = new HashSet<String>(fbFriendIDs);
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getFbID() {
        return fbId;
    }

    @Override
    public String getEmailID() {
        return emailId;
    }

    @Override
    public Set<String> getFBFriendsIDs() {
        return fbFriendIDs;
    }

    @Override
    public Set<String> getFriendsIDs() {
        return friendIDs;
    }
}
