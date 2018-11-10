package br.com.alura.payment.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.payment.entity.Payment;
import br.com.alura.payment.repository.PaymentRepository;
import br.com.alura.payment.restapi.PaymentDto;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;

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
	
	public List<PaymentDto> getReceiptByUser() {
		return null;
	}
}
