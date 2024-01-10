package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Utente;
import it.corso.service.UtenteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/prenotazione")
public class PrenotazioneController {
	
	@Autowired
	UtenteService utenteService;

	@GetMapping
	public String  visualizzaFormPrenotazione(Model model) {
		Utente utente = new Utente();
		model.addAttribute("utente", utente);
		return "contattaci";
	}
	
	@PostMapping
	public String formManager(@Valid @ModelAttribute("utente") Utente utente,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "contattaci";}else{	
		utenteService.registraPrenotazioneUtente(utente);
		model.addAttribute("appointmentReceived", true);
		return "redirect:/prenotazione";
			}		
	}
}
