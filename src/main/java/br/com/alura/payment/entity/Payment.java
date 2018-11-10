package br.com.alura.payment.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import br.com.alura.payment.enums.StatusEnum;

@Entity
public class Payment implements Serializable {
	
	private static final long serialVersionUID = 9041599595288660601L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type="uuid-char")
	private UUID id;
	
	@Type(type="uuid-char")
	private UUID user;
	
	private LocalDate periodInit;
	private LocalDate periodEnd;
	
	private Payment() {
		this(null);
	}
	
	public Payment(UUID user) {
		this.user = user;
		this.periodInit = LocalDate.now();
		this.periodEnd = this.periodInit.plusYears(1);
	}
	
	public StatusEnum getStatus(){
		LocalDate hoje = LocalDate.now();
		
		if(hoje.isAfter(this.periodEnd)){
			return StatusEnum.FINALIZADO;
		}
		return StatusEnum.EM_ANDAMENTO;
	}

	public UUID getId() {
		return id;
	}
	

	public UUID getUser() {
		return user;
	}

	public LocalDate getPeriodInit() {
		return periodInit;
	}

	public LocalDate getPeriodEnd() {
		return periodEnd;
	}

}
