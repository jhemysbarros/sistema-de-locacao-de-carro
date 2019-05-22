package modelo;

public enum TipoCliente {
	P_FISICA("Pessoa F�sica"), P_JURIDICA("Pessoa Jur�dica");

	String tipoCliente;

	private TipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
}