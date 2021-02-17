package br.com.java.financeiro.model;

import java.io.Serializable;
import java.util.Calendar;

import br.com.java.financeiro.enumeracao.SituacaoConta;

public abstract class Conta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String descricao;
	private Double valor;
	private Calendar dataVencimento;
	
	protected SituacaoConta situacaoConta;
	
	public Conta() {
		this.situacaoConta = SituacaoConta.PENDENTE;
	}
	
	public void cancelar() {
		if (SituacaoConta.CANCELADA.equals(situacaoConta)) {
			System.err.println("Não é possível cancelar uma conta que já foi Cancelada.");
		} else if (SituacaoConta.PAGA.equals(situacaoConta)) {
			System.err.println("Não é possível cancelar uma conta que já foi Paga.");
		} else {
			imprimirCancelamento();
			
			// Alterar para situação CANCELADA
			this.situacaoConta = SituacaoConta.CANCELADA;
		}
	}
	
	private void imprimirCancelamento() {
		System.out.println();
		System.out.println("*********** CANCELAMENTO AUTORIZADO ***********");
		System.err.println("Cancelando conta: " + descricao);
		System.err.println("Valor: " + valor);
		System.out.println();
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public SituacaoConta getSituacaoConta() {
		return situacaoConta;
	}

}
