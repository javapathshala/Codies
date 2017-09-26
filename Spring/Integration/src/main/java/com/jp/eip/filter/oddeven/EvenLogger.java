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
package com.jp.eip.filter.oddeven;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 *
 * A POJO Service Activator that logs even numbers and the current time.
 *
 * @author Dimit Chadha
 * @since 1.0
 * @version 1.0
 */
@MessageEndpoint
public class EvenLogger
{

    private static Logger logger = Logger.getLogger(EvenLogger.class);

    @ServiceActivator
    public void log(int i)
    {
        logger.info("even: " + i + " at " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
}
