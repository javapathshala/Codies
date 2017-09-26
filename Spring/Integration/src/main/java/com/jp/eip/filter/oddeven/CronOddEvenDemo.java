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

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * Demonstrates a method-invoking inbound Channel Adapter acting as a Polling
 * Consumer with a cron-based trigger. That adapter is followed, downstream, by
 * a simple method-invoking Message Filter that discards negative numbers to
 * the "nullChannel". Next is a Content Based Router. The router sends to one of
 * two channels based on whether the payload number is odd or even. Each of
 * those two channels has an Event Driven Consumer ready to log the number
 * and the current time.
 * <p>
 * See the 'cronOddEvenDemo.xml' configuration file for more detail. The cron
 * expression is based on the Fibonacci sequence. Feel free to modify it.
 *
 * @author Dimit Chadha
 * @since 1.0
 * @version 1.0
 */
public class CronOddEvenDemo
{

    public static void main(String[] args)
    {
        new ClassPathXmlApplicationContext("/com/jp/eip/oddeven.xml", CronOddEvenDemo.class);
    }
}
