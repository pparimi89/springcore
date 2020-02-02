package com.sample.springcore.disample;

import com.sample.springcore.disample.service.FurtherCheck;
import com.sample.springcore.disample.service.MaruthiCar;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DiTest {
    public static void main(final String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.sample.springcore.disample.service");
        context.refresh();
        //FurtherCheck furtherCheck = (FurtherCheck)context.getBean("furtherCheck");
        MaruthiCar maruthiCar = (MaruthiCar)context.getBean("maruthiCar");
        //MaruthiCar maruthiCar1 = context.getBean(MaruthiCar.class);
        System.out.println(maruthiCar.getEngine().getEngineDetails());
    }

}
