package com.sample.springcore.disample.service;

import org.springframework.stereotype.Component;

public class FiatEngine implements Engine {

    @Override
    public String getEngineDetails() {
        return "1.5L Diesel Engine";
    }
}
