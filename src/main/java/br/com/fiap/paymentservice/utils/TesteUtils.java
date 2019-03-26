package br.com.fiap.paymentservice.utils;

import java.math.BigDecimal;

public class TesteUtils {

	public static void main(String[] args) {
		BigDecimal bd = new BigDecimal("4353");
		Util.arredondar(bd);
	}
}
