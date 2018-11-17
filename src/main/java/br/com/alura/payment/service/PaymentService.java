package br.com.alura.payment.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.payment.entity.Payment;
import br.com.alura.payment.entity.PaymentDto;
import br.com.alura.payment.entity.ReceiptDto;
import br.com.alura.payment.entity.UserDto;
import br.com.alura.payment.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private UserService userService;

	public void save(UUID user) {
		Payment payment = new Payment(user);
		paymentRepository.save(payment);
	}
	
	public List<PaymentDto> getByUser(UUID user){
		List<Payment> paymentList = this.paymentRepository.findByUser(user);
		
		return paymentList.stream()
							.map(p -> new PaymentDto(p))
							.collect(Collectors.toList());
		
	}
	
	public ReceiptDto getReceiptByUser(UUID user) {
		Payment payment = this.paymentRepository.findTopByUser(user);
		
		UserDto userDto = userService.getUser(user);
		
		return new ReceiptDto(payment, userDto);
	}
}
