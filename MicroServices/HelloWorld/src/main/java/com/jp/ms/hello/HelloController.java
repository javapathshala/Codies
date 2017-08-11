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
package com.jp.ms.hello;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 *
 * @author Dimit Chadha
 * @since 1.0
 * @version 1.0
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
@ConfigurationProperties(prefix="helloapp")
@EnableEurekaServer
public class HelloController
{

    private String saying;

    @RequestMapping(method = RequestMethod.GET, value = "/hola", produces = "text/plain")
    public String hola() throws UnknownHostException
    {
        String hostname = null;
        try
        {
            hostname = InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e)
        {
            hostname = "unknown";
        }
        return saying + " " + hostname;
    }

    public String getSaying()
    {
        return saying;
    }

    public void setSaying(String saying)
    {
        this.saying = saying;
    }
}
