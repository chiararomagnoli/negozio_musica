package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Utente;
import it.corso.service.UtenteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/prenotazione")
public class PrenotazioneController {
	
	@Autowired
	UtenteService utenteService;
	

	@GetMapping
	public String getPage(Model model, @RequestParam(name="id", required=false) Integer idProdotto) {
		Utente utente = new Utente();
		model.addAttribute("utente", utente);
		model.addAttribute("id", idProdotto.intValue());
		
		return "contattaci";
	}
	
	@PostMapping
	public String formManager(@Valid @ModelAttribute("utente") Utente utente,
			@RequestParam(name="id", required=false) Integer idProdotto,
			BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "contattaci";}else{	
		utenteService.registraPrenotazioneUtente(utente);
		model.addAttribute("appointmentReceived", true);
		return "redirect:/prenotazione?id="+idProdotto.intValue();
			}
		//
		//idProdotto= idProdotto==null? 0 : ;
	}
}
