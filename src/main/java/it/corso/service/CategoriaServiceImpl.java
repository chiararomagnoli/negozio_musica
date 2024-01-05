package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.CategoriaDao;
import it.corso.model.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaDao categoriaDao;

	@Override
	public void registraCategoria(Categoria categoria) {
		categoriaDao.save(categoria);

	}

	@Override
	public Categoria getCategoriaById(int id) {
		return categoriaDao.findById(id).get();
	}

	@Override
	public List<Categoria> getCategorie() {
		return (List<Categoria>) categoriaDao.findAll();
	}

	@Override
	public void cancellaCategoria(Categoria categoria) {
		categoriaDao.delete(categoria);
	}

}
