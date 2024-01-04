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
	private  int id;
	
	@Column(name = "nome_sottocategoria")
	private String nome_sottocategoria;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_id_categoria", referencedColumnName = "id_categoria")
	private Categoria categoria;
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_sottocategoria() {
		return nome_sottocategoria;
	}

	public void setNome_sottocategoria(String nome_sottocategoria) {
		this.nome_sottocategoria = nome_sottocategoria;
	}

}
