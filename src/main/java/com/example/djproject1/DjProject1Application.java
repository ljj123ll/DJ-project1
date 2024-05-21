package com.example.djproject1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
@MapperScan("com.example.djproject1.mapper")
public class DjProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(DjProject1Application.class, args);
	}

}
