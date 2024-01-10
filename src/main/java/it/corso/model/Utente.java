package it.corso.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;

public class Utente {

	@Pattern(regexp = "[a-zA-Z\\s']{1,50}", message = "Caratteri non ammessi")
	private String nome;
	
	@Pattern(regexp = "[a-zA-Z\\s']{1,50}", message = "Caratteri non ammessi")
	private String cognome;
	
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$", message = "Indirizzo email non valido")
	private String email;
	 
	@Digits(integer = 15, fraction = 0, message = "Numero di telefono non valido")
	private String telefono;

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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
