package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.corso.model.Prodotto;

public interface ProdottoDao extends CrudRepository<Prodotto, Integer> {
	
	//query di order by per la seconda pagina html
	List<Prodotto> findAllByOrderByNomeProdottoAsc();
	
	List<Prodotto> findAllByCondizione(String condizione);
	
	List<Prodotto> findAllBySconto(double sconto);
	
	//metodi utili per il form di ricerca
	List<Prodotto> findByNomeProdottoContaining(String nome);

}
