package com.seven.boot.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author QH
 */
@SpringBootApplication(scanBasePackages = {"com.seven.boot.wx", "com.seven.boot.core", "com.seven.boot.common", "com.seven.boot.dao"})
public class ConsignWxApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsignWxApiApplication.class, args);
    }
}
