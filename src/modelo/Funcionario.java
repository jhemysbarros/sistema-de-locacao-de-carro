package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aplicacao.BDCarro;
import aplicacao.BDPessoa;

public class Funcionario extends Pessoa {

	// Atributos de Funcion�rio.
	private int matricula;
	private String cargo;
	private Cliente cliente;

	// Construtor default de Funcion�rio.
	public Funcionario() {
	}

	// Construtor principal de Funcion�rio.
	public Funcionario(int matricula, String nome, String cpf, String contato, String email, String datasNascimento,
			String usuario, String senha) {
		super(nome, cpf, contato, email, datasNascimento, usuario, senha);
	}

	// M�todo respons�vel por exibir o menu de Funcion�rio.
	@Override
	public void menu(BDPessoa bdp, BDCarro bdc) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<Carro> carros = new ArrayList<Carro>();

		Scanner entrada = new Scanner(System.in);

		System.out.println("\t\n=============== Menu Funcionario ===============\n");
		System.out.println("[1] Ger�ncia de Ve�culos");
		System.out.println("[2] Ger�ncia de Clientes");
		System.out.println("[3] Sair.");
		System.out.print("\nOp��o ==> ");

		int opcaoMenuFuncionario = entrada.nextInt();

		switch (opcaoMenuFuncionario) {
		case 1:
			System.out.println("\t\n=============== Ger�ncia de Ve�culos ===============\n");
			System.out.println("[1] Adicionar um Ve�culo");
			System.out.println("[2] Listar Ve�culos");
			System.out.println("[3] Buscar Ve�culo");
			System.out.println("[4] Sair.");
			System.out.print("\nOp��o ==> ");

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

				System.out.print("\nQual ID do Carro voc� deseja utilizar: ");
				int numero = entrada.nextInt();

				Carro cEscolhido = carros.get(numero - 1);

				System.out.println();
				cEscolhido.imprimir();

				System.out.println("\t\n=============== Alterar dados do Cliente ===============\n");
				System.out.println("[1] Alterar nome do Cliente.");
				System.out.println("[2] Excluir Cliente.");
				System.out.println("[3] Sair.");

				System.out.print("\nOp��o ==> ");
				int opcaoAlterarCarro = entrada.nextInt();

				switch (opcaoAlterarCarro) {
				case 1:
					entrada.nextLine();
					System.out.print("\nInforme do novo nome: ");
					String novoNome = entrada.nextLine();

					// cEscolhido corresponde a um cliente que j� existe, logo, quando dou um
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
					System.out.println("\nPor favor, digite uma op��o v�lida");
					this.menu(bdp, bdc);
					break;
				}
				break;
			case 4:
				System.out.println("\nObrigado pela preferencia!");
				System.exit(0);
				break;
			default:
				System.out.println("\nPor favor, digite uma op��o v�lida");
				this.menu(bdp, bdc);
				break;
			}
			break;
		case 2:
			System.out.println("\t\n=============== Ger�ncia de Clientes ===============\n");
			System.out.println("[1] Adicionar um cliente.");
			System.out.println("[2] Listar Clientes.");
			System.out.println("[3] Sair.");

			System.out.print("\nOp��o ==> ");
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

				System.out.print("Tipo de pessoa.. [1] F�sica e [2] Jur�dica: ");
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

				System.out.print("Usu�rio: ");
				cadastroCliente.setUsuario(entrada.nextLine());

				System.out.print("Senha: ");
				cadastroCliente.setSenha(entrada.nextLine());

				bdp.adicionarCliente(cadastroCliente);

				System.out.println();
				bdp.listarCliente();

				this.menu(bdp, bdc);
				break;
			case 2:
				System.out.println("\t\n=============== Op��o de impress�o ===============\n");
				System.out.println("[1] Op��o de listagem.");
				System.out.println("[2] Buscar Clientes.");
				System.out.println("[3] Sair.");

				System.out.print("\nOp��o ==> ");
				int opcaoMenuListar = entrada.nextInt();

				switch (opcaoMenuListar) {
				case 1:
					entrada.nextLine();
					System.out.println("\t\n=============== Op��o de listagem ===============\n");
					System.out.println("[1] Listar todos os Clientes.");
					System.out.println("[2] Listar clientes por ordem de ID.");
					System.out.println("[3] Listar clientes por ordem alfab�tica.");
					System.out.println("[4] Listar clientes por ordem de Tipo de Pessoa.");
					System.out.println("[5] Sair.");

					System.out.print("\nOp��o ==> ");
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
						System.out.println("\nPor favor, digite uma op��o v�lida");
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

					System.out.print("\nQual n�mero do Cliente voc� deseja utilizar: ");
					int numero = entrada.nextInt();

					Cliente cEscolhido = clientes.get(numero - 1);

					System.out.println();
					cEscolhido.imprimir();

					System.out.println("\t\n=============== Alterar dados do Cliente ===============\n");
					System.out.println("[1] Alterar nome do Cliente.");
					System.out.println("[2] Excluir Cliente.");
					System.out.println("[3] Sair.");

					System.out.print("\nOp��o ==> ");
					int opcaoAlterarCliente = entrada.nextInt();

					switch (opcaoAlterarCliente) {
					case 1:
						entrada.nextLine();
						System.out.print("\nInforme do novo nome: ");
						String novoNome = entrada.nextLine();

						// cEscolhido corresponde a um cliente que j� existe, logo, quando dou um
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
						System.out.println("\nPor favor, digite uma op��o v�lida");
						this.menu(bdp, bdc);
						break;
					}
					break;
				case 3:
					System.out.println("\nObrigado pela preferencia!");
					System.exit(0);
					break;
				default:
					System.out.println("\nPor favor, digite uma op��o v�lida");
					this.menu(bdp, bdc);
					break;
				}
				break;
			case 3:
				System.out.println("\nObrigado pela preferencia!");
				System.exit(0);
				break;
			default:
				System.out.println("\nPor favor, digite uma op��o v�lida");
				this.menu(bdp, bdc);
				break;
			}

			break;
		case 3:
			System.out.println("\nObrigado pela preferencia!");
			System.exit(0);
			break;
		default:
			System.out.println("\nPor favor, digite uma op��o v�lida");
			this.menu(bdp, bdc);
			break;
		}
	}

	// Sobrescrita do toString.
	@Override
	public String toString() {
		return "Funcion�rio --> Matricula: " + getMatricula() + ", Nome: " + getNome() + ", CPF: " + getCpf()
				+ ", Contato: " + getContato() + ", E-mail: " + getEmail() + ", Data de Nascimento: "
				+ getDataNascimento() + ", Usu�rio: " + getUsuario() + ", Senha: " + getSenha() + "]";
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