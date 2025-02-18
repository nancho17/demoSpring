package com.example.demo;

import com.example.demo.run.Location;
import com.example.demo.run.Run;
import com.example.demo.run.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {SpringApplication.run(DemoApplication.class, args); }
	//log.info("App started succes aleales es ent");
	//ConfigurableApplicationContext contextInst = SpringApplication.run(DemoApplication.class, args);
	//WelcomeMessage welMeObj = (WelcomeMessage) contextInst.getBean("welcomeMessage");
	//System.out.println(welMeObj.getWelcomeMEssage());

//	@Bean
//	CommandLineRunner runner(RunRepository runRepository){
//		return args -> {
//			Run correr = new Run(1,"First RUn runio", LocalDateTime.now(),LocalDateTime.now().plus(10, ChronoUnit.HOURS),5, Location.OUTDOOR);
//			runRepository.create(correr);
//		};
//	}

}
