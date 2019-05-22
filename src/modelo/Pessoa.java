package modelo;

import aplicacao.BDCarro;
import aplicacao.BDPessoa;

abstract public class Pessoa implements Menu {

	// Atributos de Pessoa
	private String nome;
	private String cpf;
	private String contato;
	private String email;
	private String dataNascimento;
	private String usuario;
	private String senha;

	// Construtor default de Pessoa.
	public Pessoa() {
	}

	// Construtor principal de Pessoa.
	public Pessoa(String nome, String cpf, String contato, String email, String datasNascimento, String usuario,
			String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.contato = contato;
		this.email = email;
		this.usuario = usuario;
		this.senha = senha;
		this.dataNascimento = datasNascimento;
	}

	// Implementação do método menu, da interface Menu.
	@Override
	abstract public void menu(BDPessoa bdp, BDCarro bdc);

	// Implementação do método imprimir, da interface Menu.
	@Override
	abstract public void imprimir();

	// Getters e Setters dos atributos de Pessoa.
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}