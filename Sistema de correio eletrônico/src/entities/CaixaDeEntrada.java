package entities;

import java.util.ArrayList;
import java.util.List;

public class CaixaDeEntrada {
	
	private List<Email> emailsCaixaDeEntrada;
	
	
	public CaixaDeEntrada() {
		this.emailsCaixaDeEntrada = new ArrayList<>();
	}


	public List<Email> getEmailsCaixaDeEntrada() {
		return emailsCaixaDeEntrada;
	}
	
	public Email mostrarEmails() {
		for(Email e : emailsCaixaDeEntrada) {
			System.out.println(e);
		}
		return null;
	}

	public Email adicionarEmail(Email email) {
		emailsCaixaDeEntrada.add(email);
		return null;
	}

	public Email removerEmail(int posicao) {
		Email temp = emailsCaixaDeEntrada.remove(posicao - 1);
		return temp;
	}
	
	
}
