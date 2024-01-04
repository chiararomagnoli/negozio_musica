package it.corso.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Prodotto;

public interface ProdottoDao extends CrudRepository<Prodotto, Integer> {
	
	//query di order by per la seconda pagina html
	List<Prodotto> findAllByOrderByNomeProdottoAsc();

}
