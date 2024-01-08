package it.corso.service;

import java.util.List;

import it.corso.model.Prodotto;

public interface ProdottoService {
	
	void registraProdotto(Prodotto prodotto);
	Prodotto getProdottoById(int id);
	List<Prodotto> getProdotti();
	void cancellaProdotto(Prodotto prodotto);
	
	List<Prodotto> trovamiProdottiPerCondizione(String condizione);
	List<Prodotto> trovamiProdottiPerSconto (double sconto);
	
	//metodo per ordinare i prodotti in ordine alfabeiìtico
	List<Prodotto> ordinaProdottiPerNome();
	
	//metodi utili per il form di ricerca
	List<Prodotto> cercaProdottiPerNome(String nome);
	List<Prodotto> cercaProdottiPerNomeCategoria(String nomeCategoria);
	
	//Prova
	List<Prodotto> getProdotti(int idMarca, int idCategoria, int idSottocategoria, String condizione);


}
