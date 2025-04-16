package com.mandu.springBoot_Kafka_project_wikimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKafkaProjectWikimediaApplication implements CommandLineRunner{
	//CommandLineRunner is an interface that can be used to execute code after the Spring application has started
	//This is useful for running tasks that need to be executed after the application context has been loaded
	//and the Spring application has started
	//In this case, we are using it to start the streaming process
	@Autowired
	private WikimediaChangesProducer wikimediaChangesProducer;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaProjectWikimediaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// here the arguments String... args are passed to the run method
		// Start the streaming process
		wikimediaChangesProducer.startStreaming();
	}
}
