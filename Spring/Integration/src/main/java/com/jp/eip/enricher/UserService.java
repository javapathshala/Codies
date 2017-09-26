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

import java.util.Map;

/**
 *
 *
 *
 * @author Dimit Chadha
 * @since 1.0
 * @version 1.0
 */
public interface UserService {

    /**
     * Retrieves a user based on the provided user. User object is routed to the
     * "findUserEnricherChannel" channel.
     * @param user
     * @return 
     */
    User findUser(User user);

    /**
     * Retrieves a user based on the provided user. User object is routed to the
     * "findUserByUsernameEnricherChannel" channel.
     * @param user
     * @return 
     */
	User findUserByUsername(User user);

    /**
     * Retrieves a user based on the provided username that is provided as a Map
     * entry using the mapkey 'username'. Map object is routed to the
     * "findUserWithMapChannel" channel.
     */
	Map<String, Object> findUserWithUsernameInMap(Map<String, Object> userdata);
}
