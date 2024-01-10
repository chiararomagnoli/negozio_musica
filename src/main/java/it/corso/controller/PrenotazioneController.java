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
	public String getPage(Model model, @RequestParam(name="id", required=false) Integer idProdotto, 
			@RequestParam(name="nome", required=false) String nome, 
			@RequestParam(name="cognome", required = false) String cognome) {
		
		if(nome==null&&cognome==null) {
			model.addAttribute("appointmentReceived", false);
			model.addAttribute("utente", new Utente());
			
		}else {
			Utente utente=new Utente();
			utente.setNome(nome);
			utente.setCognome(cognome);
			model.addAttribute("appointmentReceived", true);
			model.addAttribute("utente", utente);
		}

		
		model.addAttribute("id", idProdotto==null? 0:idProdotto.intValue());
		
		
		return "contattaci";
	}
	//@RequestParam(name="id", required=false) Integer idProdotto,?id="+idProdotto.intValue()
	@PostMapping
	public String formManager(@Valid @ModelAttribute("utente") Utente utente,
			
			BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "contattaci";}else{	
		utenteService.registraPrenotazioneUtente(utente);
		model.addAttribute("appointmentReceived", true);
        System.out.println("Form compiled successfully. Setting appointmentReceived to true.");

		return "redirect:/prenotazione?nome="+utente.getNome()+"&cognome="+utente.getCognome();
			}
	}
}
