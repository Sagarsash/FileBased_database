package com.MikoAi.filedatabase.FileDatabaseApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.MikoAi.filedatabase")
public class FileDatabaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(FileDatabaseApplication.class, args);
	}
}

