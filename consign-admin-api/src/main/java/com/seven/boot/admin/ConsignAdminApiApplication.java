package com.seven.boot.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * admin api 启动程序
 *
 * @author QH
 */
@EnableOpenApi
@SpringBootApplication(scanBasePackages = {"com.seven.boot.admin", "com.seven.boot.core", "com.seven.boot.common", "com.seven.boot.dao"})
public class ConsignAdminApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsignAdminApiApplication.class, args);
    }
}
