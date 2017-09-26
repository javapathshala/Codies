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

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

/**
 *
 * Message -> Channel -> ServiceActivator -> QueueChannel
 * <p>
 * Demonstrates a basic Message Endpoint that simply prepends a greeting
 * ("Hello ") to an inbound String payload from a Message. This is a very
 * low-level example, using Message Channels directly for both input and
 * output. Notice that the output channel has a queue sub-element. It is
 * therefore a PollableChannel and its consumers must invoke receive() as
 * demonstrated below.
 *
 * @author Dimit Chadha
 * @since 1.0
 * @version 1.0
 */
public class HelloRunner
{

    public static void main(String[] args)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("/com/jp/integration/hello.xml", HelloRunner.class);

        MessageChannel inputChannel = context.getBean("inputChannel", MessageChannel.class);
        PollableChannel outputChannel = context.getBean("outputChannel", PollableChannel.class);

        inputChannel.send(new GenericMessage<String>("Dimit Chadha"));

        System.out.println("==> Message thrown out by out-channel : " + outputChannel.receive(0).getPayload());

    }
}
