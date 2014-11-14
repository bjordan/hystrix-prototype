package org.barryjordan.hystrixprototype.controller;

import org.barryjordan.hystrixprototype.model.Profile;
import org.barryjordan.hystrixprototype.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.Callable;

/**
 * Defines end points for a users Profile.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    private ProfileService profileService;

    /**
     * Creates a new instance.
     *
     * @param profileService User profile service.
     */
    public ProfileController(final ProfileService profileService) {
        this.profileService = profileService;
    }

    /**
     * Gets a users full profile.
     *
     * @param userID The users unique ID.
     * @return Callable containing ResponseEntity with a users full profile.
     */
    @RequestMapping(value = "/{userID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Callable<ResponseEntity<Profile>> getProfile(@PathVariable final int userID) {
        return new Callable<ResponseEntity<Profile>>() {
            @Override
            public ResponseEntity<Profile> call() {
                return new ResponseEntity<>(profileService.getProfile(userID), HttpStatus.OK);
            }
        };
    }
}