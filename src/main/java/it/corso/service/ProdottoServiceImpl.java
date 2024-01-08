package it.corso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.ProdottoDao;
import it.corso.model.Prodotto;

@Service
public class ProdottoServiceImpl implements ProdottoService {
	
	@Autowired
	private ProdottoDao prodottoDao;

	@Override
	public void registraProdotto(Prodotto prodotto) {
		prodottoDao.save(prodotto);

	}

	@Override
	public Prodotto getProdottoById(int id) {
		return prodottoDao.findById(id).get();
	}

	@Override
	public List<Prodotto> getProdotti() {
		return (List<Prodotto>) prodottoDao.findAll();
	}

	@Override
	public void cancellaProdotto(Prodotto prodotto) {
		prodottoDao.delete(prodotto);

	}

	@Override
	public List<Prodotto> trovamiProdottiPerCondizione(String condizione) {
		return prodottoDao.findAllByCondizione(condizione);
	}

	@Override
	public List<Prodotto> trovamiProdottiPerSconto(double sconto) {
		return prodottoDao.findAllBySconto(sconto);
	}
	
	//metodo per ordinare i prodotti per nome
	@Override
	public List<Prodotto> ordinaProdottiPerNome(){
		return prodottoDao.findAllByOrderByNomeProdottoAsc();
	}
	
	//metodi utili per il form di ricerca
	//ricerca prodotto per nome
	@Override
    public List<Prodotto> cercaProdottiPerNome(String nome) {
        return prodottoDao.findByNomeProdottoContaining(nome);
    }
	
	@Override
	public List<Prodotto> cercaProdottiPerNomeCategoria(String nomeCategoria) {
	    return prodottoDao.findByCategoriaNomeCategoria(nomeCategoria);
	}

	@Override
	public List<Prodotto> getProdotti(int idMarca, int idCategoria, String condizione) {
		List<Prodotto> risultati=new ArrayList<>();
		/*if(idMarca==0 && idCategoria!=0 && condizione!=null && !condizione.isEmpty()) {
			risultati=prodottoDao.findAllByCondizioneAndFkCategoria(condizione, idCategoria);
		}else if(idMarca==0 && idCategoria==0 && condizione!=null && !condizione.isEmpty()) {
			risultati=prodottoDao.findAllByCondizione(condizione);
		}else if(idMarca==0 && idCategoria!=0 && condizione==null) {
			risultati=prodottoDao.findAllByFkCategoria(idCategoria);
		}else if(idMarca!=0 && idCategoria!=0 && condizione!=null && !condizione.isEmpty()) {
			risultati=prodottoDao.findAllByFkMarcaAndFkCategoriaAndCondizione(idMarca, idCategoria, condizione);
		}else if(idMarca!=0 && idCategoria==0 && condizione==null) {
			risultati=prodottoDao.findAllByFkMarca(idMarca);
		}else if(idMarca!=0 && idCategoria==0 && condizione!=null && !condizione.isEmpty()) {
			risultati=prodottoDao.findAllByFkMarcaAndCondizione(idMarca, condizione);
		}else if(idMarca!=0 && idCategoria!=0 && condizione==null) {
			risultati=prodottoDao.findAllByFkMarcaAndFkCategoria(idMarca, idCategoria);
		}else if(idMarca==0 && idCategoria==0 && condizione==null) {
			risultati=(List<Prodotto>) prodottoDao.findAll();
		}*/
		risultati=prodottoDao.find(idMarca, idCategoria, condizione);
		

		return risultati;
	}
	
	

}