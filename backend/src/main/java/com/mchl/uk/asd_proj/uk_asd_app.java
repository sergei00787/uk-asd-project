package com.mchl.uk.asd_proj;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication()
public class uk_asd_app {

    public static void main(String[] args) {
        Environment environment = SpringApplication.run(uk_asd_app.class, args).getEnvironment();
        log.info("Start SwaggerUI to use the UKFFA APIs: "
                + "http://localhost:{}/swagger-ui/index.html#", environment.getProperty("server.port"));
    }

}
