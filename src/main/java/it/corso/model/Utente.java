package it.corso.model;

import jakarta.validation.constraints.Pattern;

public class Utente {

	@Pattern(regexp = "[a-zA-Z\\s'] {1,50}", message= "Caratteri non ammessi")
	private String nome;
	
	@Pattern(regexp = "[a-zA-Z\\s'] {1,50}", message= "Caratteri non ammessi")
	private String cognome;
	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Indirizzo email non valido")
	private String email;
	 
	@Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Numero di telefono non valido")
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
