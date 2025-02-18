package com.example.demo;

import com.example.demo.user.User;
import com.example.demo.user.UserHttpClient;
import com.example.demo.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;


@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {SpringApplication.run(DemoApplication.class, args); }
	//log.info("App started succes aleales es ent");
	//ConfigurableApplicationContext contextInst = SpringApplication.run(DemoApplication.class, args);
	//WelcomeMessage welMeObj = (WelcomeMessage) contextInst.getBean("welcomeMessage");
	//System.out.println(welMeObj.getWelcomeMEssage());

	@Bean
	UserHttpClient userHttpClient(){
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(UserHttpClient.class);
	}


	@Bean
	CommandLineRunner runner(UserHttpClient client) {
		return args -> {
			List<User> users = client.findAll();
			//System.out.println(users);

			User user = client.findById(1);
			System.out.println(user);

		};

	}
		//	CommandLineRunner runner(RunRepository runRepository){
//		return args -> {
//			Run correr = new Run(1,"First RUn runio", LocalDateTime.now(),LocalDateTime.now().plus(10, ChronoUnit.HOURS),5, Location.OUTDOOR);
//			runRepository.create(correr);
//		};
//	}

}
