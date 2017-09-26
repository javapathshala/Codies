/*
 * Copyright (c) Java Pathshala.
 * All rights reserved.
 *
 * This program is protected by copyright law but you are authorise to learn
 * & gain ideas from it. Its unauthorised use is explicitly prohibited &
 * any addition & removal of material. If want to
 * suggest any changes, you are welcome to provide your comments on GitHub
 * Social Code Area. Its unauthorised use gives Java Pathshala the right to
 * obtain retention orders and to prosecute the authors of any infraction.
 * www.javapathshala.com
 */
package com.jp.eip.enricher;

import org.apache.log4j.Logger;

/**
 *
 *
 *
 * @author Dimit Chadha
 * @since 1.0
 * @version 1.0
 */
public class SystemService
{

    private static final Logger LOGGER = Logger.getLogger(SystemService.class);

    /** Default Constructor. */
    public SystemService()
    {
        super();
    }

    public User findUser(User user)
    {
        LOGGER.info(String.format("Calling method 'findUser' with parameter %s", user));

        final User fullUser = new User(user.getUsername(),
                "secret",
                user.getUsername() + "@springintegration.org");
        return fullUser;
    }

    public User findUserByUsername(String username)
    {

        LOGGER.info(String.format("Calling method 'findUserByUsername' with parameter: %s", username));

        return new User(username, "secret", username + "@springintegration.org");

    }
}
