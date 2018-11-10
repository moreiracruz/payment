package br.com.alura.payment.restapi;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping(path = "/{user}")
	public ResponseEntity<?> save(@PathVariable("user") final UUID user) {
		paymentService.save(user);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(path = "/{user}")
	public ResponseEntity<List<PaymentDto>> getByUser(@PathVariable("user") final UUID user) {
		return ResponseEntity.ok(this.paymentService.getByUser(user));
		
	}
	
}
