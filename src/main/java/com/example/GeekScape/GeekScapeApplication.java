package com.example.GeekScape;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeekScapeApplication {

	public static void main(String[] args) {

		try {
			SpringApplication.run(GeekScapeApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
