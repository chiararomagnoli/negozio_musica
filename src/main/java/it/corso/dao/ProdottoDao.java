package it.corso.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Prodotto;

public interface ProdottoDao extends CrudRepository<Prodotto, Integer> {
	
	//query di order by per la seconda pagina html
	//List<Prodotto> findAllByOrderByNome_ProdottoAsc();
	
	List<Prodotto> findAllByCondizione(String condizione);
	
	List<Prodotto> findAllBySconto(double sconto);

}
