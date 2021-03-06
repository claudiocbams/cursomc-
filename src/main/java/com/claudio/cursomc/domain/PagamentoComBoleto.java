package com.claudio.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.claudio.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
@Entity
//@Table(name="PagamentoComBoleto")
@JsonTypeName("pagamentoComBoleto")
public class PagamentoComBoleto extends Pagamento {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataVencimento;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date  dataPagamento;
	
	
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public PagamentoComBoleto() {
	
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		this.dataPagamento =dataPagamento;
		this.dataVencimento =dataVencimento;
	}
	
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}


}
