/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp.ms.cal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author DChadha
 */
@RestController
//@EnableConfigurationProperties
@EnableAutoConfiguration
@EnableEurekaClient
//@RequestMapping("/add")

public class CalService {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/cal/add/{num1}/{num2}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String calAdd(@PathVariable(name = "num1") int num1,
            @PathVariable(name = "num2") int num2) {
        String result = restTemplate.getForObject("http://ADD-SERVICE/add/" + num1 + "/" + num2, String.class);
        return result;
    }

    @RequestMapping(value = "/info",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String info() {
        return "Add service is up. Author- DC";
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
