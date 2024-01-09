package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Prodotto;
import it.corso.service.ProdottoService;

@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {
	
	@Autowired
	private ProdottoService prodottoService;
	
	
	@GetMapping
	public String getPage(@RequestParam(name="id", required=true) int id, Model model) {
		List<Prodotto> prodotti = prodottoService.getProdotti();
		model.addAttribute("prodotto", prodotti.get(id-1));
		return "dettaglio";
	}

}
