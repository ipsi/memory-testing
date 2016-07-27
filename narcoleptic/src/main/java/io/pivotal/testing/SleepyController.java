package io.pivotal.testing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SleepyController {

    @RequestMapping("/provide")
    public String provideForDevouring() throws InterruptedException {
        Thread.sleep(100 + new Random().nextInt(40_000)); // Sleep between 0.1s and 40.1s
        return "{\"consumable\": \"whole roast oxen\"}";
    }
}
