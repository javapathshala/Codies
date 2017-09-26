/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jp.ms.add;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DChadha
 */
@RestController
//@EnableConfigurationProperties
@EnableAutoConfiguration
@EnableEurekaClient
//@RequestMapping("/add")
public class AddService {

    @RequestMapping(value = "/add/{num1}/{num2}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String add(@PathVariable(name = "num1") int num1,
            @PathVariable(name = "num2") int num2) {
        return Integer.toString(num1 + num2);
    }

    @RequestMapping(value = "/info",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String info() {
        return "Add service is up. Author- DC";
    }
}
