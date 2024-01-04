package it.corso.service;

import java.util.List;

import it.corso.model.Sottocategoria;

public interface SottocategoriaService {

	void registraSottocategoria(Sottocategoria sottocategoria);
	Sottocategoria getSottocategoriaById(int id);
	List<Sottocategoria> getSottocategoria();
	void cancellaCliente(Sottocategoria sottocategoria);
	
}
