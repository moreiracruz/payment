package br.com.alura.payment.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.alura.payment.entity.UserDto;

@Service
public class UserService {
	
	private static final String USER_API = "http://192.168.0.241:8080";
	private static final String GET_USER = "/api/users";
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallback")
	public UserDto getUser(UUID user) {
		
		String url = USER_API + GET_USER + user.toString();
		
		ResponseEntity<UserDto> forEntity = restTemplate.getForEntity(url, UserDto.class);
		UserDto userDto = forEntity.getBody();
		
		return userDto;
	}
	
	public UserDto fallback(UUID user) {
		System.out.println("Erro ao consultar o usuário: " + user.toString());
		return new UserDto();
	}
}
