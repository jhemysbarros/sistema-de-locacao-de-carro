package modelo;

import aplicacao.BDCarro;
import aplicacao.BDPessoa;

public interface Menu {

	public void menu(BDPessoa bdp, BDCarro bdc);
	
	public void imprimir();
}