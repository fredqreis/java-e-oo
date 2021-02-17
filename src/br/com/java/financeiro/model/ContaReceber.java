package br.com.java.financeiro.model;

import java.util.Calendar;

import br.com.java.financeiro.enumeracao.SituacaoConta;

public class ContaReceber extends Conta {

	private static final long serialVersionUID = 1L;
	
	private static final double CINQUENTA_MIL = 50000;
	
	private Cliente cliente;
	
	public ContaReceber(Cliente cliente, String descricao, Double valor, Calendar dataVencimento) {
		this.cliente = cliente;
		this.setDescricao(descricao);
		this.setValor(valor);
		this.setDataVencimento(dataVencimento);
	}
	
	public void receber() {
		if (SituacaoConta.CANCELADA.equals(situacaoConta)) {
			System.err.println("Não é possível receber uma conta que está Cancelada.");
		} else if (SituacaoConta.PAGA.equals(situacaoConta)) {
			System.err.println("Não é possível receber uma conta que está Paga.");
		} else {
			imprimirRecebimento();
			
			// Alterar para situação PAGA
			this.situacaoConta = SituacaoConta.PAGA;
		}
	}
	
	@Override
	public void cancelar() {
		if (getValor() > CINQUENTA_MIL) {
			System.err.println("Conta a receber não pode ser Cancelada, valor superior a 50.000,00");
		}
		
		super.cancelar();
	}
	
	private void imprimirRecebimento() {
		System.out.println("================ CONTAS A RECEBER ================");
		System.out.println("Cliente: " + cliente.getNome());
		System.out.println("Descrição: " + this.getDescricao());
		System.out.println("Valor: " + this.getValor());
		System.out.println("Data de vencimento: " + this.getDataVencimento().getTime());
		System.out.println("Situação: " + this.getSituacaoConta());
		System.out.println("========================  ========================");
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
