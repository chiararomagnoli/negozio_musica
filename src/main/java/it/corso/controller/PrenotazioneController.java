package it.corso.controller;


import java.time.LocalTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.corso.model.Utente;
import it.corso.service.CategoriaService;
import it.corso.service.ProdottoService;
import it.corso.service.SottocategoriaService;
import it.corso.service.UtenteService;

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
	
//@RequestParam(name="errore", required=false) Boolean errore
	@GetMapping
	public String getPage(Model model,
	                      @RequestParam(name = "id", required = false) Integer idProdotto,
	                      RedirectAttributes redirectAttributes) {

	    Utente utente = new Utente();
	 
	    Boolean appointmentReceived = (Boolean) model.getAttribute("appointmentReceived");

	    if (appointmentReceived != null && appointmentReceived) {
	        // Imposta gli attributi del modello dai RedirectAttributes
	        model.addAttribute("id", redirectAttributes.getAttribute("id"));
	        model.addAttribute("nome", redirectAttributes.getAttribute("nome"));
	        //String nome = (String) model.getAttribute("nome");
	       	utente = (Utente) model.asMap().get("utente");
	        model.addAttribute("cognome", redirectAttributes.getAttribute("cognome"));	
	        //String cognome = (String) model.getAttribute("cognome");
	        System.out.println("Qui vediamo il nome " + utente.getNome());
	        // Genera un orario casuale a intervalli di 30 minuti tra le 9:00 e le 17:30
	        LocalTime orarioCasuale = generaOrarioCasuale();
	        // Passa l'orario casuale al modello
	        model.addAttribute("orarioCasuale", orarioCasuale);
	        model.addAttribute("utente", utente);
	        model.addAttribute("appointmentReceived", true);

	        // Rimuovi gli attributi dai RedirectAttributes
	        redirectAttributes.getFlashAttributes().clear();
	    }else {
	    	model.addAttribute("appointmentReceived", false);
	    	model.addAttribute("utente", utente);
	    }   
	    
	    model.addAttribute("id", idProdotto == null ? 0 : idProdotto.intValue());
	    model.addAttribute("prodotto", prodottoService.getProdottoById(idProdotto));


	    // Resto del tuo codice...
	    model.addAttribute("sottocategorie", sottocategoriaService.getSottocategoria());
	    model.addAttribute("categorie", categoriaService.getCategorie());
	    model.addAttribute("sottocategorieChitarre", sottocategoriaService.getSottocategoriaByIdCategoria(1));
	    model.addAttribute("sottocategorieTastiere", sottocategoriaService.getSottocategoriaByIdCategoria(2));
	    model.addAttribute("sottocategorieArchi", sottocategoriaService.getSottocategoriaByIdCategoria(3));
	    model.addAttribute("sottocategoriePercussioni", sottocategoriaService.getSottocategoriaByIdCategoria(4));
	    model.addAttribute("sottocategorieFiati", sottocategoriaService.getSottocategoriaByIdCategoria(5));

	    return "contattaci";
	}

	
	
	@PostMapping
	public String formManager(@ModelAttribute("utente") Utente utente, @RequestParam("id") Integer idProdotto,
	                         RedirectAttributes redirectAttributes) {
	    utenteService.registraPrenotazioneUtente(utente);
	    redirectAttributes.addAttribute("id", idProdotto.intValue());
	    redirectAttributes.addFlashAttribute("utente", utente);
	    redirectAttributes.addFlashAttribute("appointmentReceived", true);

	    return "redirect:/prenotazione";
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