package de.luanpabloj.eletronicEmail.methods;

import de.luanpabloj.eletronicEmail.methods.Email;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter
public final class Enviados {
	
	private List<Email> emailsEnviados;

	public Enviados() {
		this.emailsEnviados = new ArrayList<>();
	}

	public Email mostrarEmails() {
		for(Email e : emailsEnviados) {
			System.out.println(e);
		}
		return null;
	}

	public void adicionarEmail(Email email) {
		emailsEnviados.add(email);
	}

	
	public Email removerEmail(int posicao) {
		return null;
	}
}
