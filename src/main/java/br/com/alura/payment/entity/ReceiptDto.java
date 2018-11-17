package br.com.alura.payment.entity;

public class ReceiptDto extends PaymentDto {

	private UserDto userDto;

	public ReceiptDto(Payment payment, UserDto userDto) {
		super(payment);
		this.userDto = userDto;
	}

	public String getUserName() {
		return userDto.getNome();
	}

}
