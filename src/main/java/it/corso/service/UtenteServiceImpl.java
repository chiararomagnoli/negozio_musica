package it.corso.service;

public class UtenteServiceImpl implements UtenteService {

	@Override
	public void registraPrenotazioneUtente(Utente utente) {
		System.out.println(utente.getNome() + " registrato");		
	}

}
