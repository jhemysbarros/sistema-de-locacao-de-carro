package modelo;

public enum TipoCliente {
	P_FISICA("Pessoa Física"), P_JURIDICA("Pessoa Jurídica");

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