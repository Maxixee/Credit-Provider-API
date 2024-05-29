package com.hiegobarreto.credit_analysis;

import com.hiegobarreto.credit_analysis.domain.service.CreditAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@SpringBootApplication
public class CreditAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditAnalysisApplication.class, args);
	}

}
