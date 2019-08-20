package com.restful.parentchild;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParentChildApplication {
    private static Logger LOGGER = LogManager.getLogger(ParentChildApplication.class);

	public static void main(String[] args) {
        LOGGER.info("Starting Spring Boot Parent-Child App...");
        start();
    }

    public static void start() {
        SpringApplication.run(ParentChildApplication.class);
	}

}
