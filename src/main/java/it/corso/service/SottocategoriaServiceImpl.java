package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.SottocategoriaDao;
import it.corso.model.Sottocategoria;

@Service
public class SottocategoriaServiceImpl implements SottocategoriaService
{
	@Autowired
	private SottocategoriaDao sottocategoriaDao;

	@Override
	public void registraSottocategoria(Sottocategoria sottocategoria) {
		
		sottocategoriaDao.save(sottocategoria);
		
	}

	@Override
	public Sottocategoria getSottocategoriaById(int id) {
		
		return sottocategoriaDao.findById(id).get();
	}

	@Override
	public List<Sottocategoria> getSottocategoria() {
		return (List<Sottocategoria>) sottocategoriaDao.findAll();
		
	}

	@Override
	public void cancellaCliente(Sottocategoria sottocategoria) {
		sottocategoriaDao.delete(sottocategoria);
		
	}

}
