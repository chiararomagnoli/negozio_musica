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

	@Query(value = "SELECT * FROM prodotti p WHERE "
			+ "(:fkMarca=0 OR :fkMarca = p.fk_marca) "
	        + "AND "
	        + "(:fkCategoria=0 OR :fkCategoria = p.fk_categoria) "
	        + "AND "
	        + "(:fkSottocategoria=0 OR :fkSottocategoria = p.fk_sottocategoria) "
	        + "AND "
	        + "(:condizione IS NULL OR  :condizione = p.condizione) "
	        + "OR "
	        + "(:fkCategoria=0 AND :fkMarca=0 AND :fkSottocategoria=0 AND :condizione IS NULL)"
	        + "ORDER BY p.nome_prodotto ASC",
	        nativeQuery = true)
	List<Prodotto> find(
			@Param("fkMarca") int fkMarca,
	        @Param("fkCategoria") int fkCategoria,
	        @Param("fkSottocategoria") int fkSottocategoria,
	        @Param("condizione") String condizione
	);


}
