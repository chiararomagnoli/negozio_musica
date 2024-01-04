package it.corso.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // la classe rappresenta un'entità persistente, ovvero un oggetto che può essere memorizzato in un database
@Table(name = "prodotti") // specifica il nome della tabella associata
public class Prodotto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome_prodotto")
	private String nome_prodotto;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "prezzo")
	private double prezzo;
	
	@Column(name = "disponibilita")
	private int disponibilita;
	
	@Column(name = "sconto")
	private double sconto;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fk_categoria", referencedColumnName = "id_categoria")
	private Categoria categoria;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fk_sottocategoria", referencedColumnName = "id_sottocategoria")
	private Sottocategoria sottocategoria;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fk_marca", referencedColumnName = "id_marca")
	private Marca marca;
	
	
	@Column(name = "condizione")
	private String condizione;
}
