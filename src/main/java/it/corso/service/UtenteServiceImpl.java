package it.corso.service;

import org.springframework.stereotype.Service;

import it.corso.model.Utente;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Override
	public void registraPrenotazioneUtente(Utente utente) {
		System.out.println(utente.getNome() + " registrato");		
	}

}
