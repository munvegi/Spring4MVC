package com.munvegi.springmvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.munvegi.springmvc.configuration",
        "com.munvegi.springmvc.aspects",
        "com.munvegi.springmvc.dao",
        "com.munvegi.springmvc.model",
        "com.munvegi.springmvc.service"})
public class AppConfiguration {
	

}