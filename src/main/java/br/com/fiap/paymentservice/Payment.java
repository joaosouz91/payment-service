package br.com.fiap.paymentservice;

import java.math.BigDecimal;

import br.com.fiap.paymentservice.enums.BandeiraCartao;
import br.com.fiap.paymentservice.enums.FormaPagamento;
import br.com.fiap.paymentservice.enums.StatusPagamento;
import br.com.fiap.paymentservice.utils.Util;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Payment {
	
	private long idTransacao;
	private FormaPagamento formaPagamento;
	private String numeroCartao;
	private String validadeCartao;
	private BandeiraCartao bandeiraCartao;
	private StatusPagamento statusPagamento;
	private BigDecimal valorCompra = BigDecimal.ZERO;

	public Payment(){
		this.statusPagamento = StatusPagamento.WAITING;
	}
	
	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = Util.arredondar(valorCompra);
	}
}

