package br.com.alura.payment.restapi;

import java.time.LocalDate;
import java.util.UUID;

import br.com.alura.payment.entity.Payment;
import br.com.alura.payment.enums.StatusEnum;

public class PaymentDto {

	private final Payment payment;

	public PaymentDto(Payment payment) {
		super();
		this.payment = payment;
	}
	
	public UUID getId(){
		return this.payment.getId();
	}

	public UUID getUser(){
		return this.payment.getUser();
	}
	
	public LocalDate getPeriodoInit(){
		return this.payment.getPeriodInit();
	}
	
	public LocalDate getPeriodoEnd(){
		return this.payment.getPeriodEnd();
	}
	
	public StatusEnum getStatus(){
		return this.payment.getStatus();
	}
}
