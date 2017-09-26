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

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 *
 *
 * @author Dimit Chadha
 * @since 1.0
 * @version 1.0
 */
public class Runner
{

    private static final Logger LOGGER = Logger.getLogger(Runner.class);

    private static final String LINE_SEPARATOR = "\n==========================================================================";
    private static final String EMPTY_LINE = "\n                                                                          ";

    public static void main(String[] args)
    {

        final AbstractApplicationContext context = new ClassPathXmlApplicationContext("/com/jp/eip/enricher.xml");
        context.registerShutdownHook();

        final Scanner scanner = new Scanner(System.in);

        final UserService service = context.getBean(UserService.class);

        LOGGER.info(LINE_SEPARATOR
                + EMPTY_LINE
                + "\n    Please press 'q + Enter' to quit the application.                     "
                + EMPTY_LINE
                + LINE_SEPARATOR
                + EMPTY_LINE
                + "\n    This example illustrates the usage of the Content Enricher.           "
                + EMPTY_LINE
                + "\n    Usage: Please enter 1 or 2 or 3 + Enter                               "
                + EMPTY_LINE
                + "\n    3 different message flows are triggered. For sample 1+2 a             "
                + "\n    user object containing only the username is passed in.                "
                + "\n    For sample 3 a Map with the 'username' key is passed in and enriched  "
                + "\n    with the user object using the 'user' key.                            "
                + EMPTY_LINE
                + "\n    1: In the Enricher, pass the full User object to the request channel. "
                + "\n    2: In the Enricher, pass only the username to the request channel.    "
                + "\n    3: In the Enricher, pass only the username to the request channel.    "
                + EMPTY_LINE
                + LINE_SEPARATOR);

        while (!scanner.hasNext("q"))
        {

            final String input = scanner.nextLine();

            User user = new User("foo", null, null);

            if ("1".equals(input))
            {

                final User fullUser = service.findUser(user);
                printUserInformation(fullUser);

            }
            else if ("2".equals(input))
            {

                final User fullUser = service.findUserByUsername(user);
                printUserInformation(fullUser);

            }
            else if ("3".equals(input))
            {

                final Map<String, Object> userData = new HashMap<String, Object>();
                userData.put("username", "foo_map");

                final Map<String, Object> enrichedUserData = service.findUserWithUsernameInMap(userData);

                final User fullUser = (User) enrichedUserData.get("user");

                printUserInformation(fullUser);

            }
            else
            {
                LOGGER.info("\n\n    Please enter '1', '2', or '3' <enter>:\n\n");
            }

        }

        LOGGER.info("\n\nExiting application...bye.");

        System.exit(0);
    }

    private static void printUserInformation(User user)
    {

        if (user != null)
        {
            LOGGER.info(String.format("\n\n    User found - Username: '%s',  Email: '%s', Password: '%s'.\n\n",
                    user.getUsername(), user.getEmail(), user.getPassword()));
        }
        else
        {
            LOGGER.info("\n\n    No User found for username: 'foo'.\n\n");
        }
    }
}
