package modelo;

import java.util.Scanner;

import aplicacao.BDCarro;
import aplicacao.BDPessoa;

public class Cliente extends Pessoa {

	// Atributos de Cliente.
	private int idCliente;
	private String habilitacao;
	private TipoCliente tipoCliente;

	// Construtor default de Cliente.
	public Cliente() {
	}

	// Construtor principal de Cliente.
	public Cliente(int idCliente, String nome, String habilitacao, String cpf, String contato, String email,
			String datasNascimento, String usuario, String senha, TipoCliente statusDePagamento) {
		super(nome, cpf, contato, email, datasNascimento, usuario, senha);
		this.idCliente = idCliente;
		this.habilitacao = habilitacao;
		this.tipoCliente = statusDePagamento;
	}

	// Método responsável por exibir o menu de opção de Cliente.
	@Override
	public void menu(BDPessoa bdp, BDCarro bdc) {
		Scanner entrada = new Scanner(System.in);

		System.out.println("\t\n=============== Cliente ===============\n");
		System.out.println("Qual tipo de veículo deseja alugar?\n");
		System.out.println("[1] Carro de Passeio");
		System.out.println("[2] Esportivo");
		System.out.println("[3] Off Road");
		System.out.println("[4] Listar todos os carros");
		System.out.println("[4] Sair.");
		System.out.print("\nOpção ==> ");
		int opcao = entrada.nextInt();

		switch (opcao) {
		case 1:
			Carro.menuCarroPasseio();
			break;
		case 2:
			Carro.menuCarroEsportivo();
			break;
		case 3:
			Carro.menuCarroOffRoad();
			break;
		case 4:
			System.out.println();
			bdc.listarCarro();
			break;
		case 5:
			System.out.println("\nObrigado pela preferencia!");
			System.exit(0);
			break;
		default:
			System.out.println("\nPor favor, digite uma opção válida");
			this.menu(bdp, bdc);
			break;
		}
	}

	// Sobrescrita do toString.
	@Override
	public String toString() {
		return "Cliente --> idCliente: " + getIdCliente() + ", Nome: " + getNome() + ", Habilitacao: " + habilitacao
				+ ", CPF: " + getCpf() + ", Tipo de pessoa: " + getTipoCliente() + ", Contato: " + getContato()
				+ ", E-mail: " + getEmail() + ", Data de Nascimento: " + getDataNascimento() + ", Usuário: "
				+ getUsuario() + ", Senha: " + getSenha() + "]";
	}

	// Sobrescrita do imprimir herdado de Pessoa para imprimir o toString.
	@Override
	public void imprimir() {
		System.out.println(this.toString());
	}

	// Getters e Setters dos atributos de Cliente.
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
}