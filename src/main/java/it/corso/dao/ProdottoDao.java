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
	
	List<Prodotto> findAllByFkMarca(int idMarca);
	
	
	//metodi utili per il form di ricerca
	List<Prodotto> findByNomeProdottoContaining(String nome);
	List<Prodotto> findByCategoriaNomeCategoria(String nomeCategoria);

	List<Prodotto> findAllByFkCategoria(int idCategoria);

	List<Prodotto> findAllByFkMarcaAndFkCategoriaAndCondizione(int idMarca, int idCategoria, String condizione);

	List<Prodotto> findAllByFkMarcaAndCondizione(int idMarca, String condizione);

	List<Prodotto> findAllByCondizioneAndFkCategoria(String condizione, int idCategoria);

	List<Prodotto> findAllByFkMarcaAndFkCategoria(int idMarca, int idCategoria);

/*	@Query(value = "SELECT * FROM Prodotti p WHERE "
	        + "(:fkCategoria IS NULL OR :fkCategoria = p.fk_categoria) "
	        + "AND "
	        + "(:fkMarca IS NULL OR :fkMarca = p.fk_marca) "
	        + "AND "
	        + "(:condizione IS NULL OR :condizione = p.condizione) "
	        + "OR "
	        + "(:fkCategoria IS NULL AND :fkMarca IS NULL AND :condizione IS NULL)",
	        nativeQuery = true)
	List<Prodotto> find(
	        @Param("fkCategoria") Integer fkCategoria,
	        @Param("fkMarca") Integer fkMarca,
	        @Param("condizione") String condizione
	);*/


}
