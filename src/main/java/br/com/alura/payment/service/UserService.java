package br.com.alura.payment.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.alura.payment.entity.UserDto;

@Service
public class UserService {
	
	@Value("${services.url.users}")
	private String USER_API;
	
	@Value("${user.api.port}")
	private String PORT;
	
	@Value("${user.api.getuser}")
	private String GET_USER;
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallback")
	public UserDto getUser(UUID user) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("http://");
		sb.append(USER_API);
		sb.append(":");
		sb.append(PORT);
		sb.append(GET_USER);
		sb.append(user.toString());
		
		String url =  sb.toString();
		
		ResponseEntity<UserDto> forEntity = restTemplate.getForEntity(url, UserDto.class);
		UserDto userDto = forEntity.getBody();
		
		return userDto;
	}
	
	public UserDto fallback(UUID user) {
		System.out.println("Erro ao consultar o usuário: " + user.toString());
		return new UserDto("N/A");
	}
}
