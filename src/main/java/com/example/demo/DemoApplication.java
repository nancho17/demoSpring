package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
