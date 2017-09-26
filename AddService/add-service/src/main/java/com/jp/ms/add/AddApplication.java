/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp.ms.add;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @author DChadha
 */
@SpringBootApplication
@EnableAutoConfiguration
//@EnableDiscoveryClient

public class AddApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AddService.class, args);
    }
}
