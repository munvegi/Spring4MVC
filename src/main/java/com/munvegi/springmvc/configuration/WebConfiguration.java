package com.munvegi.springmvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by admin on 22/07/2016.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.munvegi.springmvc.controller")
public class WebConfiguration {
}
