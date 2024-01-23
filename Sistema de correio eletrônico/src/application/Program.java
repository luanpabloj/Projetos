package application;

import java.util.ArrayList;
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
					if(usuarioEncontrado) {
						System.out.println("Conectado no e-mail: " + emailUser);
						System.out.println("1 - Correio eletrônico\n2 - Lixo eletrônico\n3 - Enviados\n4 - Enviar e-mail\n5 - Sair");
						System.out.print("Digite a opção: ");
						int opcaoUserEmail = sc.nextInt();
						switch(opcaoUserEmail) {
							case 1:
								for(Usuario u : usuarios) {
									if(u.getEmail() == emailUser) {
										u.getCaixaDeEntrada().mostrarEmails();
									}
								}
						}
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
				System.out.print("Digite o número do usuário a ser excluido: ");
				int num = sc.nextInt();
				usuarios.remove(num);
				System.out.println("Usuário excluido");
				System.out.println();
				break;
		}
		
		}while(opcao != 4);
		
		
	}

}
