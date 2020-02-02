package com.sample.springcore.disample.service;


import org.springframework.stereotype.Component;

@Component
public class HyndaiEngine implements Engine {

    @Override
    public String getEngineDetails() {
        return "Hyndai 1.5L Diesel Engine";
    }
}
