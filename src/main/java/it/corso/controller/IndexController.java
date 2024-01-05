package it.corso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Prodotto;
import it.corso.service.ProdottoService;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private ProdottoService prodottoService;
	
	@GetMapping
	public String getPage(Model model) {
		
		model.addAttribute("prodotti", prodottoService.getProdotti());
		model.addAttribute("prodotto", new Prodotto());
		List<Prodotto> prodottiUsati = prodottoService.trovamiProdottiPerCondizione("Usato");
		model.addAttribute("prodottiUsati", prodottiUsati);
		
		List<Prodotto> prodotti = prodottoService.getProdotti();
		List<Prodotto> prodottiScontati = new ArrayList<>();
		for(Prodotto p:prodotti) {
			if(p.getSconto()!=0) {
				prodottiScontati = prodottoService.trovamiProdottiPerSconto(p.getSconto());
				}
		}
		model.addAttribute("prodottiScontati", prodottiScontati);
		
		//capire se aggiungere un model per l'id_prodotto o se usare direttamente la lista
		//dentro th:each possiamo mettere un counter per dirgli di prendere gli ultimi elementi (quelli che ci servono)
		
		return "indexprova";
	}

}
