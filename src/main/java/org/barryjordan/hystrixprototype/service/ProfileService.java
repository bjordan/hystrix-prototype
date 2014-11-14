package org.barryjordan.hystrixprototype.service;

import org.barryjordan.hystrixprototype.model.Profile;

/**
 * Defines ProfileService service calls.
 */
public interface ProfileService {

    /**
     * Gets a users full profile.
     *
     * @param userID The users unique ID.
     * @return The users {@link Profile}.
     */
    Profile getProfile(int userID);
}
