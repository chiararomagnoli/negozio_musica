package it.corso.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;

public class Utente {

	@Pattern(regexp = "[a-zA-Z\\s'] {1,50}", message= "Caratteri non ammessi")
	private String nome;
	
	@Pattern(regexp = "[a-zA-Z\\s'] {1,50}", message= "Caratteri non ammessi")
	private String cognome;
	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Indirizzo email non valido")
	private String email;
	 
	@Digits(integer = 15, fraction = 0, message = "Numero di telefono non valido")
	private long telefono;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
}
