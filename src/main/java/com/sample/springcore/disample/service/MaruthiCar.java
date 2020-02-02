package com.sample.springcore.disample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MaruthiCar {

    @Autowired
    Engine engine;

    public Engine getEngine() {
        return engine;
    }
}
