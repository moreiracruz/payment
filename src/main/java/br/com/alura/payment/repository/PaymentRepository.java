package br.com.alura.payment.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.payment.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {

	List<Payment> findByUser(UUID user);
	
	List<Payment> findByPeriodInit(LocalDate periodInit);

}
