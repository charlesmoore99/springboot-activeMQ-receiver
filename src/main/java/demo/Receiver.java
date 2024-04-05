package demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	
	@JmsListener(destination = "theQueue")
	public void processMessage(String content) {
		System.out.println("Received: " + content);
	}
}
