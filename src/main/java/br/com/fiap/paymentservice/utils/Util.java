package br.com.fiap.paymentservice.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Util {
	
	private Util() {}
	
	public static BigDecimal arredondar(BigDecimal value) {
		
		String stringb1 = value.setScale(2, RoundingMode.FLOOR).toString();
		
		/*if(stringb1.contains(".")) {
			String decimal[] = stringb1.split("\\.");
			String firstDecimalPlace = decimal[1].substring(0, 1);
			String secondDecimalPlace = decimal[1].substring(1, 2);
			
			int firstDecimalPlaceInteger = Integer.parseInt(firstDecimalPlace);
			if(Integer.parseInt(secondDecimalPlace) > 4) {
				firstDecimalPlaceInteger = firstDecimalPlaceInteger + 1;
			}
			stringb1 = decimal[0] + "." + firstDecimalPlaceInteger + "0";
		}*/
		
		BigDecimal bdfinal = new BigDecimal(stringb1);
		System.out.println("BigDecimal final: " + bdfinal);
		
		return bdfinal;
	}

}