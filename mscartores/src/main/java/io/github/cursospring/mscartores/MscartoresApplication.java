package io.github.cursospring.mscartores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MscartoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscartoresApplication.class, args);
	}

}
