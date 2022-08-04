package org.fernando.gg;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.fernando.gg"})
public class PokerApplication {
	public static void main(String[] args) {
		SpringApplication.run(PokerApplication.class, args);
	}

}
