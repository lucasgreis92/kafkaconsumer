package br.com.lgrapplications.kafka.kafkaconsumer.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "br.com.lgrapplications.kafka.kafkaconsumer.repository")
public class MongoDBConfiguration {

}
