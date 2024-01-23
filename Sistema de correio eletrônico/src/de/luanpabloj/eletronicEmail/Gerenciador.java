package de.luanpabloj.eletronicEmail;

import de.luanpabloj.eletronicEmail.methods.Email;
import de.luanpabloj.eletronicEmail.methods.types.EmailTypes;
import de.luanpabloj.eletronicEmail.methods.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public final class Gerenciador {

    private final Usuario usuario;

    public Gerenciador(Usuario usuario) {
        this.usuario = usuario;
    }

    public void mostrarEmails(EmailTypes emailTypes) {

        List<Email> emails = new ArrayList<>();
        switch (emailTypes) {
            case CAIXA_DE_ENTRADA:
                emails = usuario.getCaixaDeEntrada().getEmailsCaixaDeEntrada();
                break;
            case ENVIADOS:
                emails = usuario.getEnviados().getEmailsEnviados();
                break;
            case LIXO_ELETRONICO:
                emails = usuario.getLixoEletronico().getEmailsLixoEletronico();
                break;
        }

        if (emails.isEmpty()) {
            printar("[E-mails] Sem e-mails registrados aqui!");
            return;
        }

        for (Email cDE : emails) {
            printar("----------------------------");
            printar(cDE.toString());
            printar("----------------------------");
        }
    }

    public void enviarEmail() {
        final Scanner sc = new Scanner(System.in);

        printar("[E-mail] Digite o e-mail do usuário que deseja enviar o e-mail:");
        final String userEmail = sc.next();

        final HashMap<String, Usuario> registeredUsers = EmailMain.getUsuarios();

        if (!registeredUsers.containsKey(userEmail)) {
            printar("[E-mail] Este usuário não está cadastrado! \n");
            return;
        }
        sc.nextLine();
        printar("[E-mail] Digite o assunto do e-mail: \n");
        final String emailText = sc.nextLine();

        if (emailText.isBlank()) {
            printar("[E-mail] O assunto do e-mail não pode ser vázio! \n");
            return;
        }
        sc.nextLine();
        printar("[E-mail] Digite o conteúdo do e-mail: \n");
        final String emailContent = sc.nextLine();

        if (emailContent.isBlank()) {
            printar("[E-mail] O conteúdo do e-mail não pode ser vázio!");
            return;
        }

        final Usuario user = registeredUsers.get(userEmail);
        final Email email = new Email(usuario.getNome(), user.getNome(), emailText, emailContent);
        printar("[E-mail] O e-mail foi enviado com sucesso! \n");
        usuario.getEnviados().adicionarEmail(email);
        user.getCaixaDeEntrada().adicionarEmail(email);

        EmailMain.getUsuarios().put(usuario.getEmail(), usuario);
        EmailMain.getUsuarios().put(user.getEmail(), user);

        new EmailMain();
    }

    private void printar(String mensagem) {
        System.out.println(mensagem);
    }
}
