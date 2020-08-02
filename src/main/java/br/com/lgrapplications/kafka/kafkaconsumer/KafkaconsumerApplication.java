package br.com.lgrapplications.kafka.kafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class KafkaconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaconsumerApplication.class, args);
	}

}
