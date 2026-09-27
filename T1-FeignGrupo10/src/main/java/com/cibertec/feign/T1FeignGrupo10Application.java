package com.cibertec.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class T1FeignGrupo10Application {

	public static void main(String[] args) {
		SpringApplication.run(T1FeignGrupo10Application.class, args);
	}

}
