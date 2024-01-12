package it.corso.controller;


import java.time.LocalTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Prodotto;
import it.corso.model.Utente;
import it.corso.service.CategoriaService;
import it.corso.service.ProdottoService;
import it.corso.service.SottocategoriaService;
import it.corso.service.UtenteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/prenotazione")
public class PrenotazioneController {
	
	@Autowired
	UtenteService utenteService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	SottocategoriaService sottocategoriaService;
	
	@Autowired
	ProdottoService prodottoService;
	

	@GetMapping
	public String getPage(Model model, @RequestParam(name="id", required=false) Integer idProdotto, 
			@RequestParam(name="nome", required=false) String nome, 
			@RequestParam(name="cognome", required = false) String cognome) {
		//model utili per la navbar
		model.addAttribute("sottocategorie", sottocategoriaService.getSottocategoria());
		model.addAttribute("categorie", categoriaService.getCategorie());
        model.addAttribute("sottocategorieChitarre", sottocategoriaService.getSottocategoriaByIdCategoria(1));
        model.addAttribute("sottocategorieTastiere", sottocategoriaService.getSottocategoriaByIdCategoria(2));
        model.addAttribute("sottocategorieArchi", sottocategoriaService.getSottocategoriaByIdCategoria(3));
        model.addAttribute("sottocategoriePercussioni", sottocategoriaService.getSottocategoriaByIdCategoria(4));
        model.addAttribute("sottocategorieFiati", sottocategoriaService.getSottocategoriaByIdCategoria(5));
		//parte logica
		if(nome==null&&cognome==null) {
			model.addAttribute("appointmentReceived", false);
			model.addAttribute("utente", new Utente());
			model.addAttribute("id", idProdotto==null? 0:idProdotto.intValue());
			model.addAttribute("prodotto", prodottoService.getProdottoById(idProdotto));
		}else {
			Utente utente=new Utente();
			utente.setNome(nome);
			utente.setCognome(cognome);
			model.addAttribute("appointmentReceived", true);
			model.addAttribute("utente", utente);
			model.addAttribute("id", idProdotto==null? 0:idProdotto.intValue());
			model.addAttribute("prodotto", prodottoService.getProdottoById(idProdotto.intValue()));
			// Genera un orario casuale a intervalli di 30 minuti tra le 9:00 e le 17:30
	        LocalTime orarioCasuale = generaOrarioCasuale();

	        // Passa l'orario casuale al modello
	        model.addAttribute("orarioCasuale", orarioCasuale);
		}
		
		return "contattaci";
	}

	@PostMapping
	public String formManager(@Valid @ModelAttribute("utente") Utente utente,
			@RequestParam("id") Integer idProdotto,
			BindingResult result, Model model) {
		
		
		
		if(result.hasErrors()) {
			return "contattaci";}else{	
		utenteService.registraPrenotazioneUtente(utente);
		model.addAttribute("appointmentReceived", true);
        System.out.println("Form compiled successfully. Setting appointmentReceived to true.");
        Prodotto prodotto = prodottoService.getProdottoById(idProdotto.intValue());
        return "redirect:/prenotazione?id=" + prodotto.getIdProdotto() +
        	       "&nome=" + utente.getNome() +
        	       "&cognome=" + utente.getCognome();
			}
	}
	
	
	//Metodo per generare un orario casuale
	private LocalTime generaOrarioCasuale() {
        Random random = new Random();

        // Genera un numero casuale tra 0 e 18 (incluso) per rappresentare gli intervalli di 30 minuti
        int intervalloCasuale = random.nextInt(19);

        // Calcola l'orario casuale aggiungendo l'intervallo casuale a 9:00
        LocalTime orarioInizio = LocalTime.of(9, 0);
        return orarioInizio.plusMinutes(intervalloCasuale * 30);
    }
}