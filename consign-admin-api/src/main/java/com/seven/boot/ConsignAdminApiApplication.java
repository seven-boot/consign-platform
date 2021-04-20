package com.seven.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * admin api 启动程序
 *
 * @author QH
 */
@EnableOpenApi
@SpringBootApplication
public class ConsignAdminApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsignAdminApiApplication.class, args);
    }
}
