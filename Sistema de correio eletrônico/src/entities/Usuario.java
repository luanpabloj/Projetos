package entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nome;
	private String email;
		
	private CaixaDeEntrada caixaDeEntrada;
	private LixoEletronico lixoEletronico;
	private Enviados enviados;
	
	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.caixaDeEntrada = new CaixaDeEntrada();
		this.lixoEletronico = new LixoEletronico();
		this.enviados = new Enviados();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CaixaDeEntrada getCaixaDeEntrada() {
		return caixaDeEntrada;
	}

	public LixoEletronico getLixoEletronico() {
		return lixoEletronico;
	}

	public Enviados getEnviados() {
		return enviados;
	}
	
	public String toString() {
		return "Nome: "
				+ nome
				+ "\nEndereço de e-mail: "
				+ email;
	}

}
