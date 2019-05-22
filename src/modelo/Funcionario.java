package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aplicacao.BDCarro;
import aplicacao.BDPessoa;

public class Funcionario extends Pessoa {

	// Atributos de Funcionário.
	private int matricula;
	private String cargo;
	private Cliente cliente;

	// Construtor default de Funcionário.
	public Funcionario() {
	}

	// Construtor principal de Funcionário.
	public Funcionario(int matricula, String nome, String cpf, String contato, String email, String datasNascimento,
			String usuario, String senha) {
		super(nome, cpf, contato, email, datasNascimento, usuario, senha);
	}

	// Método responsável por exibir o menu de Funcionário.
	@Override
	public void menu(BDPessoa bdp, BDCarro bdc) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<Carro> carros = new ArrayList<Carro>();

		Scanner entrada = new Scanner(System.in);

		System.out.println("\t\n=============== Menu Funcionario ===============\n");
		System.out.println("[1] Gerência de Veículos");
		System.out.println("[2] Gerência de Clientes");
		System.out.println("[3] Sair.");
		System.out.print("\nOpção ==> ");

		int opcaoMenuFuncionario = entrada.nextInt();

		switch (opcaoMenuFuncionario) {
		case 1:
			System.out.println("\t\n=============== Gerência de Veículos ===============\n");
			System.out.println("[1] Adicionar um Veículo");
			System.out.println("[2] Listar Veículos");
			System.out.println("[3] Buscar Veículo");
			System.out.println("[4] Sair.");
			System.out.print("\nOpção ==> ");

			int opcaoMenuVeiculo = entrada.nextInt();

			switch (opcaoMenuVeiculo) {
			case 1:
				Carro cadastroCarro = new Carro();

				entrada.nextLine();
				System.out.print("\nInforme o ID do carro: ");
				cadastroCarro.setIdCarro(entrada.nextInt());

				System.out.print("Informe a placa do carro... Ex.: ABC-1234 ");
				cadastroCarro.setPlaca(entrada.nextLine());
				entrada.nextLine();

				System.out.print("Informe o modelo do carro: ");
				cadastroCarro.setModelo(entrada.nextLine());

				System.out.print("Informe o valor do aluguel do carro: ");
				cadastroCarro.setPreco(entrada.nextFloat());
				entrada.nextLine();

				bdc.adicionarCarro(cadastroCarro);

				this.menu(bdp, bdc);
				break;
			case 2:
				break;
			case 3:
				entrada.nextLine();
				System.out.print("\nInsira o ID que deseja buscar: ");

				carros = bdc.buscarCarros(entrada.nextInt());

				if (carros.size() == 0) {
					System.out.println("\nNenhum carro encontrado!");
					this.menu(bdp, bdc);
					break;
				}
				for (int i = 0; i < carros.size(); i++) {
					System.out.println("\nID: " + (i + 1) + " do carro " + carros.get(i).getModelo());
				}

				System.out.print("\nQual ID do Carro você deseja utilizar: ");
				int numero = entrada.nextInt();

				Carro cEscolhido = carros.get(numero - 1);

				System.out.println();
				cEscolhido.imprimir();

				System.out.println("\t\n=============== Alterar dados do Cliente ===============\n");
				System.out.println("[1] Alterar nome do Cliente.");
				System.out.println("[2] Excluir Cliente.");
				System.out.println("[3] Sair.");

				System.out.print("\nOpção ==> ");
				int opcaoAlterarCarro = entrada.nextInt();

				switch (opcaoAlterarCarro) {
				case 1:
					entrada.nextLine();
					System.out.print("\nInforme do novo nome: ");
					String novoNome = entrada.nextLine();

					// cEscolhido corresponde a um cliente que já existe, logo, quando dou um
					// setNome, nesse cEscolhido, ele vai sobrescrever o nome.
					cEscolhido.setModelo(novoNome);

					System.out.println();
					bdc.listarCarro();
					break;
				case 2:
					bdc.excluirCliente(cEscolhido);

					System.out.println();
					bdc.listarCarro();
					break;
				default:
					System.out.println("\nPor favor, digite uma opção válida");
					this.menu(bdp, bdc);
					break;
				}
				break;
			case 4:
				System.out.println("\nObrigado pela preferencia!");
				System.exit(0);
				break;
			default:
				System.out.println("\nPor favor, digite uma opção válida");
				this.menu(bdp, bdc);
				break;
			}
			break;
		case 2:
			System.out.println("\t\n=============== Gerência de Clientes ===============\n");
			System.out.println("[1] Adicionar um cliente.");
			System.out.println("[2] Listar Clientes.");
			System.out.println("[3] Sair.");

			System.out.print("\nOpção ==> ");
			int opcaoMenuCliente = entrada.nextInt();

			switch (opcaoMenuCliente) {
			case 1:
				Cliente cadastroCliente = new Cliente();

				entrada.nextLine();
				System.out.print("\nInforme do ID: ");
				cadastroCliente.setIdCliente(entrada.nextInt());
				entrada.nextLine();

				System.out.print("Digite o nome do Cliente: ");
				cadastroCliente.setNome(entrada.nextLine());

				System.out.print("Categoria da CNH: ");
				cadastroCliente.setHabilitacao(entrada.nextLine());

				System.out.print("CPF: ");
				cadastroCliente.setCpf(entrada.nextLine());

				System.out.print("Tipo de pessoa.. [1] Física e [2] Jurídica: ");
				int sexo = entrada.nextInt();

				if (sexo == 1)
					cadastroCliente.setTipoCliente(TipoCliente.P_FISICA);
				else
					cadastroCliente.setTipoCliente(TipoCliente.P_JURIDICA);
				entrada.nextLine();

				System.out.print("Celular: ");
				cadastroCliente.setContato(entrada.nextLine());

				System.out.print("Email: ");
				cadastroCliente.setEmail(entrada.nextLine());

				System.out.print("Informe a data de nascimento: ");
				cadastroCliente.setDataNascimento(entrada.nextLine());

				System.out.print("Usuário: ");
				cadastroCliente.setUsuario(entrada.nextLine());

				System.out.print("Senha: ");
				cadastroCliente.setSenha(entrada.nextLine());

				bdp.adicionarCliente(cadastroCliente);

				System.out.println();
				bdp.listarCliente();

				this.menu(bdp, bdc);
				break;
			case 2:
				System.out.println("\t\n=============== Opção de impressão ===============\n");
				System.out.println("[1] Opção de listagem.");
				System.out.println("[2] Buscar Clientes.");
				System.out.println("[3] Sair.");

				System.out.print("\nOpção ==> ");
				int opcaoMenuListar = entrada.nextInt();

				switch (opcaoMenuListar) {
				case 1:
					entrada.nextLine();
					System.out.println("\t\n=============== Opção de listagem ===============\n");
					System.out.println("[1] Listar todos os Clientes.");
					System.out.println("[2] Listar clientes por ordem de ID.");
					System.out.println("[3] Listar clientes por ordem alfabética.");
					System.out.println("[4] Listar clientes por ordem de Tipo de Pessoa.");
					System.out.println("[5] Sair.");

					System.out.print("\nOpção ==> ");
					int opcaoMenuoOrdenacao = entrada.nextInt();

					switch (opcaoMenuoOrdenacao) {
					case 1:
						bdc.listarCarro();
						break;
					case 2:
						//bdc.imprimirListaOrdenadaPorID();
						break;
					case 3:
						//bdc.imprimirListaOrdenadaPorNome();
						break;
					case 4:
						//bdc.imprimirListaOrdenadaTipoDePessoa();
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
					break;
				case 2:
					entrada.nextLine();
					System.out.print("\nInsira o nome que deseja buscar: ");

					clientes = bdp.buscarCliente(entrada.nextLine());

					if (clientes.size() == 0) {
						System.out.println("\nNenhum cliente encontrado!");
						this.menu(bdp, bdc);
						break;
					}
					for (int i = 0; i < clientes.size(); i++) {
						System.out.println("\nID: " + (i + 1) + " do cliente " + clientes.get(i).getNome());
					}

					System.out.print("\nQual número do Cliente você deseja utilizar: ");
					int numero = entrada.nextInt();

					Cliente cEscolhido = clientes.get(numero - 1);

					System.out.println();
					cEscolhido.imprimir();

					System.out.println("\t\n=============== Alterar dados do Cliente ===============\n");
					System.out.println("[1] Alterar nome do Cliente.");
					System.out.println("[2] Excluir Cliente.");
					System.out.println("[3] Sair.");

					System.out.print("\nOpção ==> ");
					int opcaoAlterarCliente = entrada.nextInt();

					switch (opcaoAlterarCliente) {
					case 1:
						entrada.nextLine();
						System.out.print("\nInforme do novo nome: ");
						String novoNome = entrada.nextLine();

						// cEscolhido corresponde a um cliente que já existe, logo, quando dou um
						// setNome, nesse cEscolhido, ele vai sobrescrever o nome.
						cEscolhido.setNome(novoNome);

						System.out.println();
						bdp.listarCliente();
						break;
					case 2:
						bdp.excluirCliente(cEscolhido);

						System.out.println();
						bdp.listarCliente();
						break;
					default:
						System.out.println("\nPor favor, digite uma opção válida");
						this.menu(bdp, bdc);
						break;
					}
					break;
				case 3:
					System.out.println("\nObrigado pela preferencia!");
					System.exit(0);
					break;
				default:
					System.out.println("\nPor favor, digite uma opção válida");
					this.menu(bdp, bdc);
					break;
				}
				break;
			case 3:
				System.out.println("\nObrigado pela preferencia!");
				System.exit(0);
				break;
			default:
				System.out.println("\nPor favor, digite uma opção válida");
				this.menu(bdp, bdc);
				break;
			}

			break;
		case 3:
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
		return "Funcionário --> Matricula: " + getMatricula() + ", Nome: " + getNome() + ", CPF: " + getCpf()
				+ ", Contato: " + getContato() + ", E-mail: " + getEmail() + ", Data de Nascimento: "
				+ getDataNascimento() + ", Usuário: " + getUsuario() + ", Senha: " + getSenha() + "]";
	}

	// Sobrescrita do imprimir herdado de Pessoa para imprimir o toString.
	@Override
	public void imprimir() {
		System.out.println(this.toString());
	}

	// Getters e Setters dos atributos de Funcionario.
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}