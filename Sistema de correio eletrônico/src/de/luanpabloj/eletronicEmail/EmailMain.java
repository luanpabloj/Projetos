package de.luanpabloj.eletronicEmail;

import java.util.*;

import de.luanpabloj.eletronicEmail.methods.Usuario;
import de.luanpabloj.eletronicEmail.methods.types.EmailTypes;
import lombok.Getter;


public final class EmailMain {

	//Objetos imutáveis principais.
	private final Scanner sc = new Scanner(System.in);
	@Getter
	public static final HashMap<String, Usuario> usuarios = new HashMap<>();

	/**
	 * Inicializando por este método, você poderá usar
	 * métodos não estáticos, isto vai ajudar muito.
	 */
	public EmailMain() {

		printar("[E-mail] Seja bem-vindo ao sistema de E-mails!");
		printar("1. Cadastrar um usuário.");
		printar("2. Visualizar usuários cadastrados.");
		printar("3. Remover um usuário cadastrado.");
		printar("4. Finalizar programa.");

		try {
			final byte selOption = sc.nextByte();
			switch (selOption) {
				case 1:
					createUser();
					break;
				case 2:
					listRegisteredUsers();
					break;
				case 3:
					removeUser();
					break;
				default:
					System.out.println("[E-mail] Programa encerrado!");
					sc.close();
					break;
			}
		} catch(InputMismatchException e) {
			printar("[E-mail] Ocorreu um erro, tente novamente!");
			new EmailMain();
		}
	}

	/**
	 * Cria o usuário com base no nome e e-mail,
	 * tudo isto é salvo em uma HashMap estática.
	 */
	private void createUser() {
		printar("[E-mail] Insira o nome do usuário:");
		final String userName = sc.next();

		printar("[E-mail] Insira o e-mail do usuário:");
		final String userEmail = sc.next();

		final Usuario registeringUser = new Usuario(userName, userEmail);
		printar("Nome do usuário: " + registeringUser.getNome());
		printar("E-mail do usuário: " + registeringUser.getEmail());

		if (usuarios.containsKey(userEmail)) {
			printar("[E-mail] O usuário já existe, tente novamente!");
			new EmailMain();
			return;
		}

		usuarios.put(userEmail, registeringUser);
		new EmailMain();
	}

	/**
	 * Lista os usuários, este método também faz
	 * com que o usuário possa acessar e-mails.
	 */
	private void listRegisteredUsers() {
		if (usuarios.isEmpty()) {
			printar("[E-mail] Não há usuários cadastrados!");
			new EmailMain();
			return;
		}

		for (Usuario user : usuarios.values()) {
			printar("------------------------------");
			printar("Nome do usuário: " + user.getNome());
			printar("E-mail do usuário: " + user.getEmail());
			printar("------------------------------");
		}

		printar("[E-mail] Para acessar um usuário, digite o e-mail desejado:");
		final String userEmail = sc.next();

		if (!usuarios.containsKey(userEmail)) {
			printar("[E-mail] Este usuário não está cadastrado!");
			return;
		}

		final Usuario aUser = usuarios.get(userEmail);
		final Gerenciador manager = new Gerenciador(aUser);
		printar("[E-mail] Você acessou o e-mail de " + aUser.getNome());
		printar("1. Visualizar Caixa de Entrada.");
		printar("2. Visualizar E-mails enviados.");
		printar("3. Visualizar Lixo Eletrônico.");
		printar("4. Enviar e-mail para outro.");
		printar("5. Sair do usuário.");

		try {
			final byte selOption = sc.nextByte();
			switch (selOption) {
				case 1:
					manager.mostrarEmails(EmailTypes.CAIXA_DE_ENTRADA);
					break;
				case 2:
					manager.mostrarEmails(EmailTypes.ENVIADOS);
					break;
				case 3:
					manager.mostrarEmails(EmailTypes.LIXO_ELETRONICO);
					break;
				case 4:
					manager.enviarEmail();
					break;
				default:
					new EmailMain();
					break;
			}

		} catch(InputMismatchException e) {
			printar("[E-mail] Ocorreu um erro, tente novamente!");
			new EmailMain();
		}
	}

	private void removeUser() {
		printar("[E-mail] Insira o e-mail do usuário:");
		final String userEmail = sc.next();

		if (!usuarios.containsKey(userEmail)) {
			printar("[E-mail] Este usuário não está cadastrado!");
			return;
		}

		final Usuario rUser = usuarios.get(userEmail);
		printar("[E-mail] Usuário removido!");
		printar("Nome do usuário: " + rUser.getNome());
		printar("E-mail do usuário: " + rUser.getEmail());
		usuarios.remove(userEmail);

		new EmailMain();
	}

	private void printar(String mensagem) {
		System.out.println(mensagem);
	}

	public static void main(String[] args) {
		new EmailMain();
	}
}
