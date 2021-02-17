package br.com.java.financeiro.model;

import java.util.Calendar;

import br.com.java.financeiro.enumeracao.SituacaoConta;

public class ContaPagar extends Conta {

	private static final long serialVersionUID = 1L;
	
	private Fornecedor fornecedor;
	
	public ContaPagar(Fornecedor fornecedor, String descricao, Double valor, Calendar dataVencimento) {
		this.fornecedor = fornecedor;
		this.setDescricao(descricao);
		this.setValor(valor);
		this.setDataVencimento(dataVencimento);
	}
	
	public void pagar() {
		if (SituacaoConta.CANCELADA.equals(this.getSituacaoConta())) {
			System.err.println("Não é possível pagar uma conta que está Cancelada.");
		} else if (SituacaoConta.PAGA.equals(this.getSituacaoConta())) {
			System.err.println("Não é possível pagar uma conta que está Paga.");
		} else {
			imprimirPagamento();
			
			// Alterar para situação PAGA
			this.situacaoConta = SituacaoConta.PAGA;
		}
	}
	
	private void imprimirPagamento() {
		System.out.println("*********** PAGAMENTO EFETUADO COM SUCESSO ***********");
		System.out.println("Fornecedor: " + fornecedor.getNome());
		System.out.println("Conta paga: " + this.getDescricao());
		System.out.println("Valor: " + this.getValor());
		System.out.println("Data de vencimento: " + this.getDataVencimento().getTime());
		System.out.println();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
