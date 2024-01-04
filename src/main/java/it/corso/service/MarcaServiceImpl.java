package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.MarcaDao;
import it.corso.model.Marca;

@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	private MarcaDao marcaDao;
	
	@Override
	public void registraMarca(Marca marca) {
		marcaDao.save(marca);

	}

	@Override
	public Marca getMarcaById(int id) {
		return marcaDao.findById(id).get();
	}
	
	@Override
	public List<Marca> getMarche() {
		return (List<Marca>) marcaDao.findAll();
	}

	@Override
	public void cancellaMarca(Marca prodotto) {
		marcaDao.delete(prodotto);

	}

}
