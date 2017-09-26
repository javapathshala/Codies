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

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * A simple POJO providing a method that returns incrementing integer values.
 * This is referenced in the sample's configuration by an inbound Channel
 * Adapter acting as a Polling Consumer.
 * Every 5th number will be returned as a negative value.
 *
 * @author Dimit Chadha
 * @since 1.0
 * @version 1.0
 */
public class Counter
{

    private final AtomicInteger count = new AtomicInteger();

    public int next()
    {
        int nextNumber = count.incrementAndGet();
        return (nextNumber % 5 == 0) ? -nextNumber : nextNumber;
    }
}
