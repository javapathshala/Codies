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

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
@ConfigurationProperties(prefix = "greeting")

public class GreeterRestController
{

    private String saying;
    private String backendServiceHost;
    private int backendServicePort;

    //use Spring’s RestTemplate to do the invocation of the remote service
    private RestTemplate template = new RestTemplate();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = "text/plain")
    public String greeting()
    {
        String backendServiceUrl = String.format("http://%s:%d//api/backend?greeting={greeting}", backendServiceHost, backendServicePort);
        System.out.println("Sending to: " + backendServiceUrl);
        BackendDTO response = template.getForObject(backendServiceUrl, BackendDTO.class, saying);
        return response.getGreeting() + " at host: " + response.getIp();
    }

    public String getSaying()
    {
        return saying;
    }

    public void setSaying(String saying)
    {
        this.saying = saying;
    }

    public String getBackendServiceHost()
    {
        return backendServiceHost;
    }

    public void setBackendServiceHost(String backendServiceHost)
    {
        this.backendServiceHost = backendServiceHost;
    }

    public int getBackendServicePort()
    {
        return backendServicePort;
    }

    public void setBackendServicePort(int backendServicePort)
    {
        this.backendServicePort = backendServicePort;
    }

}
