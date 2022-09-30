package com.example.hello;

import com.example.hello.model.MessageHello;
import com.example.hello.repo.MessageRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(HelloApplication.class, args);
		MessageRepo messageRepo = configurableApplicationContext.getBean(MessageRepo.class);
		messageRepo.save(new MessageHello("English", "hello world"));
		messageRepo.save(new MessageHello("Serbian", "zdravo svete"));
		messageRepo.save(new MessageHello("bosnian", "zdravo world2"));
		messageRepo.save(new MessageHello("moldavian", "hello world4"));
		messageRepo.save(new MessageHello("croatian", "hello world5"));
		messageRepo.save(new MessageHello("nesto", "hello world6"));

		List<MessageHello> k = messageRepo.findAll();
		for(MessageHello m : k){
			System.out.printf("jezik: %s, \n izraz: %s \n", m.getLanguage(), m.getTextMessage());
		}
	}

}
