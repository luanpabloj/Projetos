package entities;

import java.util.ArrayList;
import java.util.List;

public class LixoEletronico {
	
	private List<Email> emailsLixoEletronico;
	
	public LixoEletronico() {
		this.emailsLixoEletronico = new ArrayList<>();
	}

	public Email mostrarEmails() {
		for(Email e : emailsLixoEletronico) {
			System.out.println(e);
		}
		return null;
	}

	
	public Email adicionarEmail(Email email) {
		emailsLixoEletronico.add(email);
		return null;
	}

	
	public Email removerEmail(int posicao) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
