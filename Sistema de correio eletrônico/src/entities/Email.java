package entities;

public class Email {

	private String remetente;
	private String destinatario;
	private String assunto;
	private String corpo;
	
	
	public Email(String remetente, String destinatario, String assunto, String corpo) {
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.corpo = corpo;
	}


	public String getDestinatario() {
		return destinatario;
	}


	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}


	public String getAssunto() {
		return assunto;
	}


	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}


	public String getCorpo() {
		return corpo;
	}


	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}


	public String getRemetente() {
		return remetente;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Remetente: " + remetente);
		sb.append("\nDestinatário: " + destinatario);
		sb.append("\nAssunto: " + assunto);
		sb.append("\nCorpo: " + corpo);
		
		return sb.toString();
	}
	
}
