package dev.viplove.springbootstarter;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import dev.viplove.springbootstarter.repository.UserRepository;
import dev.viplove.springbootstarter.service.AutowireDependent;

@SpringBootApplication
public class SpringBootStarterApplication {
	
	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		ApplicationContext applicationContext  = SpringApplication.run(SpringBootStarterApplication.class, args);

		String depStr = applicationContext.getBean("dependencyStr",String.class);
		
		AutowireDependent a = applicationContext.getBean("autowireDependentByType",AutowireDependent.class);
		System.out.println("Dependency value - :"+a.toString());
	}
	
	@PostConstruct
	public void init() {

		
		System.out.println("Data in users' table thourgh injected userRepo: "+userRepositor.findAll());
	}
}