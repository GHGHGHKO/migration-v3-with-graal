package com.example.migrationv3withgraal;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class MigrationV3WithGraalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MigrationV3WithGraalApplication.class, args);
	}

}
