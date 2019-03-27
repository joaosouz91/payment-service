package br.com.fiap.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PaymentApplication {

	public static void main(String[] args) {
		
		/*
		Payment pay = new Payment();
		//pay.setValorCompra(Util.arredondar(payment.getValorCompra()));
		pay.setFormaPagamento(FormaPagamento.CREDITO);
		pay.setNumeroCartao("2546 1545 6544 6546");
		pay.setValidadeCartao("2028-04");
		pay.setBandeiraCartao(BandeiraCartao.MASTERCARD);
		pay.setValorCompra(new BigDecimal("342.245469"));
		
		PaymentFactory.create(pay);
		*/
		SpringApplication.run(PaymentApplication.class, args);
	}

}
