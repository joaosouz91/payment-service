package br.com.fiap.paymentservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.fiap.paymentservice.enums.StatusPagamento;
import br.com.fiap.paymentservice.utils.Util;

public class PaymentFactory {
	
	private static List <Payment> paymentList = new ArrayList<Payment>();
	private static List<Long> transacaoList = new ArrayList<Long>();
	
	public static boolean create(Payment payment) {
   		payment.setIdTransacao(getNewIdTransacao());
    	payment.setStatusPagamento(StatusPagamento.WAITING);
    	return paymentList.add(payment);
    }

    public static Payment update(Payment payment) {
    	for(Payment pay : paymentList) {
    		if(pay.getIdTransacao() == payment.getIdTransacao()) {
    			
    			//só posso mudar o pagamento se o mesmo não foi autorizado ainda    			
				if(!pay.getStatusPagamento().equals(StatusPagamento.ACCEPTED)) {
					pay.setIdTransacao(getNewIdTransacao());
					//pay.setValorCompra(Util.arredondar(payment.getValorCompra()));
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
    
    public static Payment findPaymentById(int idTransaction) {		
    	for(Payment payment : paymentList) {
    		if(idTransaction == payment.getIdTransacao()) {
    			return payment;
    		}
    	}
    	return null;
    }

	public static boolean delete(int idPayment) {
		for(Payment payment : paymentList) {
			if(idPayment == payment.getIdTransacao()) {
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

}
