package aplicacao;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Pessoa;
import modelo.TipoCliente;

public class BDPessoa {

	// Instancias de Funcionario, Cliente e Pessoa
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

	// Método para efetuar a carga de dados de funcionarios e clientes.
	public void iniciar() {
		Funcionario f1 = new Funcionario(1, "Pedro", "784.987.416-61", "9 84848484", "funcionario@gmail.com",
				"12-03-1991", "pedro", "senha1");

		Funcionario f2 = new Funcionario(2, "Bryan", "634.175.427-23", "9 8607-2368", "bryanbentodossantos_@gmail.com",
				"12-04-1991", "bryan", "senha2");

		Funcionario f3 = new Funcionario(3, "Julia", "005.543.107-08", "9 8397-0081", "juliafrancisca@gmail.com",
				"12-05-1991", "julia", "senha3");

		Cliente c1 = new Cliente(1, "João", "AB", "465.874.498-45", "9 12345678", "vandercleyson@gmail.com",
				"12-06-1991", "joao", "senha1", TipoCliente.P_FISICA);

		Cliente c2 = new Cliente(10, "Antônia", "B", "06.990.590/0001-23", "98448-6719", "antonia@gmail.com",
				"12-07-1991", "antonia", "senha2", TipoCliente.P_JURIDICA);

		Cliente c3 = new Cliente(3, "Iago", "C", "614.140.778-15", "9 8361-8070", "iago@gmail.com", "12-08-1991",
				"iago", "senha3", TipoCliente.P_FISICA);

		// Adicionando funcionarios a List<Funcionario>
		funcionarios.add(f1);
		funcionarios.add(f2);
		funcionarios.add(f3);

		// Adicionando cliente a List<Cliente>
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);

		// Adicionando Funcionario e Cliente a List<Cliente>
		listaPessoas.add(f1);
		listaPessoas.add(f2);
		listaPessoas.add(f3);
		listaPessoas.add(c1);
		listaPessoas.add(c2);
		listaPessoas.add(c3);
	}

	// Lê todos os clientes da List<Cliente> e ordena por ID
	public void imprimirListaOrdenadaPorID(List<Cliente> cliente) {
//		cliente.sort(new Comparator<Cliente>() {
//			@Override
//			public int compare(Cliente o1, Cliente o2) {
//				Integer idade = o1.getIdCliente();
//				return idade.compareTo(o2.getIdCliente());
//			}
//		});

		cliente.sort((o1, o2) -> {
			Integer idade = o1.getIdCliente();
			return idade.compareTo(o2.getIdCliente());
		});

		cliente.forEach(p -> p.imprimir());
	}

	// Imprime todos os clientes ordenado por ID.
	public void imprimirListaOrdenadaPorID() {
		this.imprimirListaOrdenadaPorID(this.clientes);
	}

	// Lê todos os clientes da List<Cliente> e ordena por nome.
	public void imprimirListaOrdenadaPorNome(List<Cliente> cliente) {
//		// ordenando por nome
//		cliente.sort(new Comparator<Cliente>() {
//
//			@Override
//			public int compare(Cliente o1, Cliente o2) {
//				return o1.getNome().compareTo(o2.getNome());
//			}
//
//		});

		cliente.stream().sorted((o1, o2) -> o1.getNome().compareTo(o2.getNome())).forEach(p -> p.imprimir());
	}

	// Imprime todos os clientes ordenado por nome.
	public void imprimirListaOrdenadaPorNome() {
		this.imprimirListaOrdenadaPorNome(this.clientes);
	}

	// Lê todos os clientes da List<Cliente> e ordena por tipo de pessoa.
	public void imprimirListaOrdenadaTipoDePessoa(List<Cliente> cliente) {
//		cliente.sort(new Comparator<Cliente>() {
//			@Override
//			public int compare(Cliente o1, Cliente o2) {
//				return o1.getTipoCliente().compareTo(o2.getTipoCliente());
//			}
//		});

		cliente.sort((o1, o2) -> o1.getTipoCliente().compareTo(o2.getTipoCliente()));

		cliente.forEach(p -> p.imprimir());
	}

	// Imprime todos os clientes ordenado por Tipo de pessoa.
	public void imprimirListaOrdenadaTipoDePessoa() {
		this.imprimirListaOrdenadaTipoDePessoa(this.clientes);
	}

	// Exclui cliente de uma lista.
	public void excluirCliente(Cliente cliente) {
		this.clientes.remove(cliente);
	}

	// Lê todos os clientes da List<Cliente>.
	public void listarCliente(List<Cliente> cliente) {
//		for (Cliente clien : cliente) {
//			clien.imprimir();
//		}
		
		cliente.forEach(clien -> clien.imprimir());
	}

	// Imprime todos os Clientes
	public void listarCliente() {
		this.listarCliente(this.clientes);
	}

	// Método para buscar pelo nome, no List<Cliente> um determinado cliente.
	public List<Cliente> buscarCliente(String nome) {
		List<Cliente> clienteBuscado = new ArrayList<Cliente>();
		for (Cliente cliente : clientes) {
			if (cliente.getNome().indexOf(nome) != -1) {
				clienteBuscado.add(cliente);
			}
		}
		return clienteBuscado;
	}

	// Método para adicionar um novo cliente a List<Cliente>.
	public Cliente adicionarCliente(Cliente cliente) {
		clientes.add(cliente);
		return cliente;
	}

	// Método para efetuar a validação do login
	public Pessoa login(String usuario, String senha) {
		// Lambda não aceita usar vareavel de fora, a não ser que ela seja final.
		final Pessoa[] usuarioLogado = new Pessoa[1];
		listaPessoas.forEach(item -> {
			if (item.getUsuario().equalsIgnoreCase(usuario) && item.getSenha().equals(senha)) {
				usuarioLogado[0] = item;
			}
		});

		try {
			return usuarioLogado[0];
		} catch (Exception e) {
			return null;
		}
	}
}