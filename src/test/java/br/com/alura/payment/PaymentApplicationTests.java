package br.com.alura.payment;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class PaymentApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(UUID.randomUUID().toString());
	}

}
