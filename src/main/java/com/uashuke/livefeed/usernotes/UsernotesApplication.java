package com.uashuke.livefeed.usernotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class UsernotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsernotesApplication.class, args);
	}

}
