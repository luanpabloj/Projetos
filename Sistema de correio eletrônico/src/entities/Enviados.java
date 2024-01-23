package entities;

import java.util.ArrayList;
import java.util.List;

public class Enviados {
	
	private List<Email> emailsEnviados;

	public Enviados() {
		this.emailsEnviados = new ArrayList<>();
	}

	public List<Email> getEmailsEnviados() {
		return emailsEnviados;
	}

	public void setEmailsEnviados(List<Email> emailsEnviados) {
		this.emailsEnviados = emailsEnviados;
	}

	
	public Email mostrarEmails() {
		for(Email e : emailsEnviados) {
			System.out.println(e);
		}
		return null;
	}

	public Email adicionarEmail(Email email) {
		emailsEnviados.add(email);
		return null;
	}

	
	public Email removerEmail(int posicao) {
		return null;
	}
	
	

}
