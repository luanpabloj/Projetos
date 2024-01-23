package de.luanpabloj.eletronicEmail.methods;

import de.luanpabloj.eletronicEmail.methods.Email;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public final class CaixaDeEntrada {

	private final List<Email> emailsCaixaDeEntrada;
	
	public CaixaDeEntrada() {
		this.emailsCaixaDeEntrada = new ArrayList<>();
	}

	public void adicionarEmail(Email email) {
		emailsCaixaDeEntrada.add(email);
	}

	public Email removerEmail(int posicao) {
        return emailsCaixaDeEntrada.remove(posicao - 1);
	}
}
