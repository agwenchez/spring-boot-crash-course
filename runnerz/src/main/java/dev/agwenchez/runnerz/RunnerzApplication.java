package dev.agwenchez.runnerz;

import dev.agwenchez.runnerz.run.Location;
import dev.agwenchez.runnerz.run.Run;
import dev.agwenchez.runnerz.run.Runs;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@SpringBootApplication
public class RunnerzApplication {

	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
		log.info("Application started successfully");
	}

	@Bean
	CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			Runs run = new Runs(1,"Morning run", 12, LocalDateTime.now(), LocalDateTime.now().plusHours(1), Location.INDOOR);
			log.info("Today's run status is {}", run);
		};
	}

}
