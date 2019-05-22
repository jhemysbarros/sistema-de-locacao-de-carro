package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aplicacao.BDCarro;
import aplicacao.BDPessoa;

public class Carro implements Menu {

	// Atributos de carro.
	private int idCarro;
	private String placa;
	private String modelo;
	private float preco;

	// Construtor default de Carro.
	public Carro() {
	}

	// Construtor principal de Carro.
	public Carro(int idCarro, String placa, String modelo, float preco) {
		super();
		this.idCarro = idCarro;
		this.placa = placa;
		this.modelo = modelo;
		this.preco = preco;
	}

	// Método para exibir o menu de carro de passeio.
	public static void menuCarroPasseio() {
		Carro carro = new Carro();
		Scanner entrada = new Scanner(System.in);

		System.out.println("\t\n=============== Opções de Carros de Passeio ===============\n");
		System.out.println("Escolha o carro de passeio que deseja alugar!\n");
		System.out.println("1. Volkswagen Voyage");
		System.out.println("2. Toyota Corolla");
		System.out.println("3. Chevrolet Prisma");
		System.out.println("4. Sair.");
		System.out.print("\nOpção ==> ");

		int opcao = entrada.nextInt();

		switch (opcao) {
		case 1:
			System.out.println("\nAlugado com sucesso!");
			break;
		case 2:
			System.out.println("\nAlugado com sucesso!");
			break;
		case 3:
			System.out.println("\nAlugado com sucesso!");
			break;
		case 4:
			System.out.println("\nObrigado pela preferencia!");
			System.exit(0);
			break;
		default:
			System.out.println("\nPor favor, digite uma opção válida");
			break;
		}
	}

	// Método para exibir o menu de carro esportivo.
	public static void menuCarroEsportivo() {
		Scanner entrada = new Scanner(System.in);

		System.out.println("\t\n=============== Opções de Carros Esportivo ===============\n");
		System.out.println("Escolha o carro esportivo que deseja alugar!\n");
		System.out.println("1. Lamborghini Gallardo");
		System.out.println("2. Lykan HyperSport");
		System.out.println("3. Pagani Huayra");
		System.out.println("4. Sair.");
		System.out.print("\nOpção ==> ");
		int opcao = entrada.nextInt();

		switch (opcao) {
		case 1:
			System.out.println("\nAlugado com sucesso!");
			break;
		case 2:
			System.out.println("\nAlugado com sucesso!");
			break;
		case 3:
			System.out.println("\nAlugado com sucesso!");
			break;
		case 4:
			System.out.println("\nObrigado pela preferencia!");
			System.exit(0);
			break;
		default:
			System.out.println("\nPor favor, digite uma opção válida");
			break;
		}
	}

	// Método para exibir o menu de carro off road.
	public static void menuCarroOffRoad() {
		Scanner entrada = new Scanner(System.in);

		System.out.println("\t\n=============== Opções de Carros Off Road ===============\n");
		System.out.println("Escolha o carro Off Road que deseja alugar!\n");
		System.out.println("1. Troller T4");
		System.out.println("2. Mitsubishi L200 Triton Sport");
		System.out.println("3. Ford Ranger Limited");
		System.out.println("4. Sair.");
		System.out.print("\nOpção ==> ");
		int opcao = entrada.nextInt();

		switch (opcao) {
		case 1:
			System.out.println("\nAlugado com sucesso!");
			break;
		case 2:
			System.out.println("\nAlugado com sucesso!");
			break;
		case 3:
			System.out.println("\nAlugado com sucesso!");
			break;
		case 4:
			System.out.println("\nObrigado pela preferencia!");
			System.exit(0);
			break;
		default:
			System.out.println("\nPor favor, digite uma opção válida");
			break;
		}
	}

	@Override
	public void menu(BDPessoa bdp, BDCarro bdc) {
	}

	// Sobrescrita do toString.
	@Override
	public String toString() {
		return "Carro --> idCarro: " + getIdCarro() + ", Placa: " + getPlaca() + ", Nome: " + getModelo()
				+ ", Preço R$:" + getPreco() + "]";
	}

	@Override
	public void imprimir() {
		System.out.println(this.toString());
	}

	// Getters e Setters dos atributos de Carro.
	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}