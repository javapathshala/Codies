/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp.ms.cal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author DChadha
 */
@SpringBootApplication
@EnableAutoConfiguration
//@EnableDiscoveryClient

public class CalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalService.class, args);
    }
}
