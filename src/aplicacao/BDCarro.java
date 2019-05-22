package aplicacao;

import java.util.ArrayList;
import java.util.List;

import modelo.Carro;
import modelo.Cliente;

public class BDCarro {

	List<Carro> carros = new ArrayList<>();

	// Método para efetuar a carga de dados de carros.
	public void iniciar() {

		// Carros de Passeio
		Carro c1 = new Carro(1, "ABC-1234", "Volkswagen Voyage", 400);
		Carro c2 = new Carro(2, "DFG-1234", "Toyota Corolla", 400);
		Carro c3 = new Carro(3, "HIJ-1234", "Chevrolet Prisma", 400);

		
		// Carros Esportivo
		Carro c4 = new Carro(4, "KLM-1234", "Lamborghini Gallardo", 1000);
		Carro c5 = new Carro(5, "NOP-1234", "Lykan HyperSport", 1000);
		Carro c6 = new Carro(6, "QRS-1234", "Pagani Huayra", 1000);

		// Carros Off Road
		Carro c7 = new Carro(7, "TUV-1234", "Troller T4", 600);
		Carro c8 = new Carro(8, "XYW-1234", "Mitsubishi L200 Triton Sport", 600);
		Carro c9 = new Carro(9, "XYW-1234", "Ford Ranger Limited", 600);
		
		// Adicionar carros a List<Carro>
		carros.add(c1);
		carros.add(c2);
		carros.add(c3);
		carros.add(c4);
		carros.add(c5);
		carros.add(c6);
		carros.add(c7);
		carros.add(c8);
		carros.add(c9);
	}
	
	// Exclui cliente de uma lista.
	public void excluirCliente(Carro carro) {
		this.carros.remove(carro);
	}

	// Lê todos os clientes da List<Cliente>.
	public void listarCarro(List<Carro> cliente) {
		for (Carro clien : cliente) {
			clien.imprimir();
		}
	}

	// Imprime todos os Clientes
	public void listarCarro() {
		this.listarCarro(this.carros);
	}

	// Método para buscar pelo ID, no List<Carro> um determinado Carro.
	public List<Carro> buscarCarros(int idCarro) {
		List<Carro> carroBuscado = new ArrayList<Carro>();
		for (Carro carro : carros) {
			if (carro.getIdCarro() == idCarro) {
				carroBuscado.add(carro);
			}
		}
		return carroBuscado;
	}
	
	// Método para adicionar um novo carro a List<Carro>.
	public Carro adicionarCarro(Carro carro) {
		carros.add(carro);
		return carro;
	}
}