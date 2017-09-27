/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp.ms.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *
 * @author DChadha
 */
@SpringBootApplication
@EnableEurekaServer
@EnableAutoConfiguration 
@EnableZuulProxy
public class EurekaServer {
    
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class, args);
    }
}
