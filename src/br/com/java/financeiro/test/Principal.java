package br.com.java.financeiro.test;

import java.util.Calendar;

import br.com.java.financeiro.model.Cliente;
import br.com.java.financeiro.model.ContaPagar;
import br.com.java.financeiro.model.ContaReceber;
import br.com.java.financeiro.model.Fornecedor;

public class Principal {

	public static void main(String[] args) {
		Fornecedor dell = new Fornecedor();
		dell.setNome("Dell");
		
		Fornecedor vaio = new Fornecedor();
		vaio.setNome("Sony Vaio");
		
		Cliente telecom = new Cliente();
		telecom.setNome("Link Telecomunicações");
		
		ContaPagar contaPagarDell = new ContaPagar(dell, "Notebook i7 8GB 1TB", 5.000d, Calendar.getInstance());
		contaPagarDell.pagar();
		contaPagarDell.cancelar();
		
		ContaPagar contaPagarVaio = new ContaPagar(vaio, "Notebook i3 4GB 500GB", 3800d, Calendar.getInstance());
		contaPagarVaio.cancelar();
		
		ContaReceber contaReceber = new ContaReceber(telecom, "Manutenção em sistema de conta online", 2250d, Calendar.getInstance());
		contaReceber.receber();
		contaReceber.cancelar();
	}

}
