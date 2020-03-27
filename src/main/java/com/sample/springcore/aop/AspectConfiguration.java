package com.sample.springcore.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.sample.springcore.aop")
@EnableAspectJAutoProxy
public class AspectConfiguration {

}
