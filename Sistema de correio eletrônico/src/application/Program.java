package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.CaixaDeEntrada;
import entities.Email;
import entities.Enviados;
import entities.LixoEletronico;
import entities.Usuario;


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Usuario> usuarios = new ArrayList<>();
		CaixaDeEntrada caixaDeEntrada;
		LixoEletronico lixoEletronico;
		Enviados enviados;
		Usuario usuario;
		
		int opcao = 0;
		do {
		try {
		System.out.println("1 - Cadastrar um usuário\n2 - Visualizar usuários cadastrados\n3 - Remover usuário\n4 - Sair");
		System.out.print("Digite uma opção: ");
		opcao = sc.nextInt();
		System.out.println();
		
		switch(opcao) {
			case 1:
				System.out.print("Digite o nome do usuário: ");
				String nome = sc.next();
				System.out.print("Digite o endereço de e-mail: ");
				String email = sc.next();
				Usuario tmp = new Usuario(nome, email);
				usuarios.add(tmp);
				System.out.println("Usuário cadastrado\nNome: " + nome + "\nEndereço de e-mail: " + email);
				System.out.println();
				break;
				
			case 2:
				boolean vazia = usuarios.isEmpty();
				if(vazia) {
					System.out.println("Nâo há usuários cadastrados");
					System.out.println();
					break;
				}
				for(Usuario u : usuarios) {
					System.out.println(u);
				}
				System.out.print("Você deseja entrar em um usuário? (s/n) ");
				char opcaoUser = sc.next().charAt(0);
				if(opcaoUser == 's') {
					System.out.print("Digite o e-mail do usuário: ");
					String emailUser = sc.next();
					boolean usuarioEncontrado = false;
					for(Usuario u : usuarios) {
						if(u.getEmail().equals(emailUser)) {
							usuarioEncontrado = true;
							break;
						}
					}
					if(!usuarioEncontrado) {
						System.out.println("Usuário não encontrado");
						System.out.println();
						break;
					}
					if(usuarioEncontrado) {
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
					}
				}
				System.out.println();
				break;
			
			case 3:
				for(Usuario u : usuarios) {
					int num = 1;
					System.out.println(num + " - " + u.getNome());
					num++;
				}
				boolean vaziaExcluir = usuarios.isEmpty();
				if(vaziaExcluir) {
					System.out.println("Nâo há usuários cadastrados");
					System.out.println();
					break;
				}
				System.out.print("Digite o número do usuário a ser excluido: ");
				int num = sc.nextInt();
				usuarios.remove(num - 1);
				System.out.println("Usuário excluido");
				System.out.println();
				break;
		}
		}catch(InputMismatchException e) {
			System.out.println("Caractere digitado inválido");
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("Não há usuário na posição digitada");
			System.out.println();
		}
		}while(opcao != 4);

		System.out.println();
		System.out.println("FIM DO PROGRAMA");
	}

}
