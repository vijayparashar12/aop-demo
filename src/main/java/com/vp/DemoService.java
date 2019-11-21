package com.vp;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DemoService {

    @LogExecutionTime
    public void sleepyMethod() throws InterruptedException {
        Thread.sleep(new Random().nextInt(10)*1000);
    }
}
