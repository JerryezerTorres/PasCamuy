package com.pasCamuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)*/
@SpringBootApplication
public class PasCamuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasCamuyApplication.class, args);
	}

}
