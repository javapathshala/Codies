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
package com.jp.eip.channel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Simple application that polls the current system time 2 times every
 * 20 seconds (20000 milliseconds).
 * The resulting message contains the time in milliseconds and the message
 * is routed to a Logging Channel Adapter which will print the time to the
 * command prompt.
 *
 *
 * @author Dimit Chadha
 * @since 1.0
 * @version 1.0
 */
public class PollerApp
{

    public static void main(String[] args) throws Exception
    {
        new ClassPathXmlApplicationContext("/com/jp/integration/poll.xml");
    }
}
