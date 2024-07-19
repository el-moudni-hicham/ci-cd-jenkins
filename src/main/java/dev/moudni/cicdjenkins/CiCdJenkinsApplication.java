package dev.moudni.cicdjenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CiCdJenkinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiCdJenkinsApplication.class, args);
	}

	@GetMapping("/azul")
	public String home() {
		return "Azul fellawen ;)";
	}
}
