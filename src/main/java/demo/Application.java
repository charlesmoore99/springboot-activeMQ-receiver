package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import jakarta.jms.ConnectionFactory;


@SpringBootApplication
@EnableJms
public class Application {
	
	public static void main(String[] args) {
		System.out.println("starting!");
		SpringApplication.run(Application.class, args);
		System.out.println("RECEIVING!");
	}
	
	@Bean
	public JmsListenerContainerFactory<?> jmsTopicContainerFactory(
			ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer )
	{
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure( factory, connectionFactory );
		factory.setPubSubDomain( true );
		return factory;
	}	
}
