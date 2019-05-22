package aplicacao;

import java.util.Scanner;

import modelo.Pessoa;

public class Principal {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		// Menu de login
		System.out.println("\t\n=============== Informa seu usuário e senha ===============\n");

		System.out.print("\tLogin: ");
		String login = entrada.nextLine().trim();

		System.out.print("\tSenha: ");
		String senha = entrada.nextLine().trim();

		BDPessoa bdp = new BDPessoa();
		bdp.iniciar();

		BDCarro bdc = new BDCarro();
		bdc.iniciar();

		Pessoa usuario = bdp.login(login, senha);

		if (usuario != null) {
			usuario.menu(bdp, bdc);
		} else {
			System.out.println("\nUsuário e/ou Senha incorretos");

		}
	}
}