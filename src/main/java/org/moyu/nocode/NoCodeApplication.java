package org.moyu.nocode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.moyu.nocode" )
public class NoCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoCodeApplication.class, args);
    }

}
