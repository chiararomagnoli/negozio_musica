package it.corso.service;

import java.util.List;

import it.corso.model.Marca;

public interface MarcaService {
	
	void registraMarca(Marca marca);
	Marca getMarcaById(int id);
	List<Marca> getMarche();
	void cancellaMarca(Marca prodotto);

}
