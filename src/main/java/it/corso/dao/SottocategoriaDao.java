package it.corso.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Sottocategoria;

public interface SottocategoriaDao extends CrudRepository<Sottocategoria, Integer> {
	
	List<Sottocategoria> findAllByCategoriaIdCategoria(int idCategoria);

}
