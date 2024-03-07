package de.luanpabloj.eletronicEmail.methods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public final class Email {

	private String remetente;
	private String destinatario;
	private String assunto;
	private String corpo;
	
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Remetente: " + remetente + "\n");
		sb.append("Destinatário: " + destinatario + "\n");
		sb.append("Assunto: " + assunto + "\n");
		sb.append("Corpo: " + corpo);
		
		return sb.toString();
	}
	
}
