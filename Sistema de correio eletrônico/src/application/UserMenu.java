package application;

import java.util.List;
import java.util.Scanner;

import entities.Email;
import entities.Usuario;

public class UserMenu{
	
	public static void userMenu(Scanner sc, List<Usuario> usuarios, String emailUser) {
		int opcaoUserEmail;
		do {
		System.out.println("Conectado no e-mail: " + emailUser);
		System.out.println("1 - Correio eletrônico\n2 - Lixo eletrônico\n3 - Enviados\n4 - Enviar e-mail\n5 - Sair");
		System.out.print("Digite a opção: ");
		opcaoUserEmail = sc.nextInt();
		switch(opcaoUserEmail) {
			case 1:
				for(Usuario u : usuarios) {
					if(u.getEmail().equals(emailUser)) {
						u.getCaixaDeEntrada().mostrarEmails();
					}
				}
				System.out.println();
			break;
			
			case 2:
				for(Usuario u : usuarios) {
					if(u.getEmail().equals(emailUser)) {
						u.getLixoEletronico().mostrarEmails();
					}
				}
				System.out.println();
			break;
			
			case 3:
				for(Usuario u : usuarios) {
					if(u.getEmail().equals(emailUser)) {
						u.getEnviados().mostrarEmails();
					}
				}
				System.out.println();
			break;
			
			case 4:
				System.out.print("Digite o endereço de e-mail do destinatário: ");
				String emailDestinatario = sc.next();
				System.out.print("Digite o assunto do e-mail: ");
				String assuntoEmail = sc.next();
				sc.nextLine();
				System.out.print("Digite o conteúdo do e-mail: ");
				String conteudoEmail = sc.next();
				sc.nextLine();
				
				Email tmpEmail = new Email(emailUser, emailDestinatario, assuntoEmail, conteudoEmail);
				
				for(Usuario u : usuarios) {
					if(u.getEmail().equals(emailDestinatario)) {
						u.getCaixaDeEntrada().adicionarEmail(tmpEmail);
						System.out.println("Email enviado");
						System.out.println();
					}
					if(u.getEmail().equals(emailUser)) {
						u.getEnviados().adicionarEmail(tmpEmail);
					}
				}
				
			break;
		}
	}while(opcaoUserEmail != 5);
		System.out.println();
		
	}
}
