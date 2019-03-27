package br.com.fiap.paymentservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.fiap.paymentservice.enums.StatusPagamento;

public class PaymentFactory {
	
	private static List <Payment> paymentList = new ArrayList<Payment>();
	private static List<Long> transacaoList = new ArrayList<Long>();
	
	public static long create(Payment payment) {
   		payment.setIdTransacao(getNewIdTransacao());
   		payment.setIdPayment(getNewIdPayment());
    	payment.setStatusPagamento(StatusPagamento.WAITING);
    	paymentList.add(payment);
    	return Collections.max(paymentList, Comparator.comparing(v -> v.getIdPayment())).getIdPayment();
    }

    public static Payment update(Payment payment) {
    	for(Payment pay : paymentList) {
    		if(pay.getIdPayment() == payment.getIdPayment()) {
    			
    			//só posso mudar o pagamento se o mesmo não foi autorizado ainda    			
				if(!pay.getStatusPagamento().equals(StatusPagamento.ACCEPTED)) {
					pay.setIdTransacao(getNewIdTransacao());
					pay.setValorCompra(payment.getValorCompra());
	    			pay.setFormaPagamento(payment.getFormaPagamento());
	    			pay.setNumeroCartao(payment.getNumeroCartao());
	    			pay.setValidadeCartao(payment.getValidadeCartao());
	    			pay.setBandeiraCartao(payment.getBandeiraCartao());
				}
    			return pay;
    		}
    	}
		return null;
    }
    
    public static Payment findPaymentById(int idPayment) {		
    	for(Payment payment : paymentList) {
    		if(idPayment == payment.getIdPayment()) {
    			return payment;
    		}
    	}
    	return null;
    }

	public static boolean delete(int idPayment) {
		for(Payment payment : paymentList) {
			if(idPayment == payment.getIdPayment()) {
				return paymentList.remove(payment);
			}
		}
		return false;
	}
	
	public static long getNewIdTransacao() {
		long idTransacao = 0;
		if(!transacaoList.isEmpty()) {
			idTransacao = Collections.max(transacaoList, Comparator.comparing(v -> v.longValue()));
		}
    	idTransacao += 1;
    	transacaoList.add(idTransacao);
    	return idTransacao;
    }
	
	public static long getNewIdPayment() {
		long idPayment = 0;
		if(!paymentList.isEmpty()) {
			idPayment = Collections.max(paymentList, Comparator.comparing(v -> v.getIdPayment())).getIdPayment();
		}
		return idPayment + 1;
	}

}
