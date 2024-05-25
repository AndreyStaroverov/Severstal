package sas.severstal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"sas.severstal"})
public class SeverstalSasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeverstalSasApplication.class, args);
	}

}
