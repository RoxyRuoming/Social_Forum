package com.rawcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@MapperScan("com.rawcoder.community.dao")
public class CommunityApplication {

	public static void main(String[] args) {

		SpringApplication.run(CommunityApplication.class, args);
		// basic spring knowledge---(for more details, visit https://spring.io/)
		// based on Tomcat; automatically create spring container;
		// automatically scan some beans(some package and some 4 annotations) and put them into the container;
		// why 4 annotations? different meaning related to the function
	}

}
