package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Usuario;


public class EmailMenu {
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Usuario> usuarios = new ArrayList<>();
		
		int opcao = 0;
		do {
			try {
			System.out.println("1 - Cadastrar um usuário\n2 - Visualizar usuários cadastrados\n3 - Remover usuário\n4 - Sair");
			System.out.print("Digite uma opção: ");
			opcao = sc.nextInt();
			System.out.println();
			
			switch(opcao) {
				case 1:
					userRegister(sc, usuarios);
					break;
					
				case 2:
					usersView(sc, usuarios);			
					break;
				
				case 3:
					userRemove(sc, usuarios);
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
	
	private static void userRegister(Scanner sc, List<Usuario> usuarios ) {
		System.out.print("Digite o nome do usuário: ");
		String nome = sc.next();
		System.out.print("Digite o endereço de e-mail: ");
		String email = sc.next();
		Usuario tmp = new Usuario(nome, email);
		usuarios.add(tmp);
		System.out.println("Usuário cadastrado\nNome: " + nome + "\nEndereço de e-mail: " + email);
		System.out.println();
	}

	private static void usersView(Scanner sc, List<Usuario> usuarios) {
		boolean vazia = usuarios.isEmpty();
		if(vazia) {
			System.out.println("Nâo há usuários cadastrados");
			System.out.println();
			return;
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
				
			}
			if(usuarioEncontrado) {
				UserMenu.userMenu(sc, usuarios, emailUser);
			}
		}
	}

	
	private static void userRemove(Scanner sc, List<Usuario> usuarios) {
		for(Usuario u : usuarios) {
			int num = 1;
			System.out.println(num + " - " + u.getNome());
			num++;
		}
		boolean vaziaExcluir = usuarios.isEmpty();
		if(vaziaExcluir) {
			System.out.println("Nâo há usuários cadastrados");
			System.out.println();
			return;
		}
		System.out.print("Digite o número do usuário a ser excluido: ");
		int num = sc.nextInt();
		usuarios.remove(num - 1);
		System.out.println("Usuário excluido");
		System.out.println();
	}
}
