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
	@Column(name="id_prodotto")
	private int idProdotto;
	
	@Column(name = "nome_prodotto")
	private String nomeProdotto;
	
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
	
	@Column(name="fk_categoria", insertable=false, updatable=false)
	private int fkCategoria;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fk_sottocategoria", referencedColumnName = "id_sottocategoria")
	private Sottocategoria sottocategoria;
	
	@Column(name="fk_sottocategoria", insertable=false, updatable=false)
	private int fkSottocategoria;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fk_marca", referencedColumnName = "id_marca")
	private Marca marca;
	
	@Column(name="fk_marca", insertable=false, updatable=false)
	private int fkMarca;
	
	@Column(name = "condizione")
	private String condizione;
	
	
	
	public int getFkSottocategoria() {
		return fkSottocategoria;
	}


	public void setFkSottocategoria(int fkSottocategoria) {
		this.fkSottocategoria = fkSottocategoria;
	}


	public int getFkCategoria() {
		return fkCategoria;
	}


	public void setFkCategoria(int fkCategoria) {
		this.fkCategoria = fkCategoria;
	}


	public int getFkMarca() {
		return fkMarca;
	}


	public void setFkMarca(int fkMarca) {
		this.fkMarca = fkMarca;
	}


	
	
	
	
	public int getId() {
		return idProdotto;
	}


	public void setId(int idProdotto) {
		this.idProdotto = idProdotto;
	}


	public String getNomeProdotto() {
		return nomeProdotto;
	}


	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	public int getDisponibilita() {
		return disponibilita;
	}


	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}


	public double getSconto() {
		return sconto;
	}


	public void setSconto(double sconto) {
		this.sconto = sconto;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Sottocategoria getSottocategoria() {
		return sottocategoria;
	}


	public void setSottocategoria(Sottocategoria sottocategoria) {
		this.sottocategoria = sottocategoria;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public String getCondizione() {
		return condizione;
	}


	public void setCondizione(String condizione) {
		this.condizione = condizione;
	}
}
