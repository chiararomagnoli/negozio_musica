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

@Entity
@Table(name = "sottocategorie")
public class Sottocategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int idSottocategoria;
	
	@Column(name = "nome_sottocategoria")
	private String nomeSottocategoria;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fk_id_categoria", referencedColumnName = "idCategoria")
	private Categoria categoria;
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getId() {
		return idSottocategoria;
	}

	public void setId(int idSottocategoria) {
		this.idSottocategoria = idSottocategoria;
	}

	public String getNomeSottocategoria() {
		return nomeSottocategoria;
	}

	public void setNome_sottocategoria(String nomeSottocategoria) {
		this.nomeSottocategoria = nomeSottocategoria;
	}

}
