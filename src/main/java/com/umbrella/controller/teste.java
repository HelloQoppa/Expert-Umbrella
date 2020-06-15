package com.umbrella.controller;

import java.util.Date;

import com.umbrella.entity.Motorista;

public class teste {
	public static void main(String[] args) {
		Motorista n = new Motorista();

		Long codigo = null;
		n.setCodigo(codigo);
		String cpf = null;
		n.setCpf(cpf);
		Date dataNascimento = null;
		n.setDataNascimento(dataNascimento);
		String nome = "luizzzz";
		n.setNome(nome);
		String numeroCNH = "wwwwwwwww";
		n.setNumeroCNH(numeroCNH);

		// n1.setCodigo(2L);
		// n1.setCpf("14");
		// n1.setDataNascimento(null);
		// n1.setNome("b");
		// n1.setNumeroCNH("2");

		// n2.setCodigo(1L); n2.setCpf("0001"); n2.setDataNascimento(null);
		// n2.setNome("a"); n2.setNumeroCNH("3");

		MotoristaController c = new MotoristaController();

		c.Save(n);
		/*
		 * for (Motorista m : c.ListAll()) { System.out.println(m.getNome()); }
		 */
	}
}
