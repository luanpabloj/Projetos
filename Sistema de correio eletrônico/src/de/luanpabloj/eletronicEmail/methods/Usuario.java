package de.luanpabloj.eletronicEmail.methods;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class Usuario {
	
	private String nome;
	private String email;
		
	private CaixaDeEntrada caixaDeEntrada;
	private LixoEletronico lixoEletronico;
	private Enviados enviados;
	
	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;

		this.enviados = new Enviados();
		this.caixaDeEntrada = new CaixaDeEntrada();
		this.lixoEletronico = new LixoEletronico();
	}

	
	public String toString() {
		final StringBuilder str = new StringBuilder();
		str.append("Nome: " + getNome() + "\n");
		str.append("E-mail: " + getEmail() + "\n");
		return str.toString();
	}
}
