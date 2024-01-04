package it.corso.service;

import java.util.List;

import it.corso.model.Categoria;

public interface CategoriaService {
	void registraCategoria(Categoria categoria);
	Categoria getCategoriaById(int id);
	List<Categoria> getCategorie();
	void cancellaCategoria(Categoria categoria);
}
