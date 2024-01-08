package it.corso.controller;

import java.util.ArrayList;
import java.util.Comparator;
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
		
        List<Prodotto> prodotti = prodottoService.getProdotti();

        // Ordino i prodotti per ID in ordine decrescente (va bene qui o lo metto in prodottoService?)
        prodotti.sort(Comparator.comparingLong(Prodotto::getId).reversed());
        
        // aggiungo alla model i prodotti già ordinati
        model.addAttribute("prodotti", prodotti);
		
		model.addAttribute("prodotto", new Prodotto());
		
		List<Prodotto> prodottiUsati = prodottoService.trovamiProdottiPerCondizione("Usato");
		model.addAttribute("prodottiUsati", prodottiUsati);
		
		List<Prodotto> prodottiScontati = new ArrayList<>();
		for(Prodotto p:prodotti) {
			if(p.getSconto()!=0) {
				prodottiScontati = prodottoService.trovamiProdottiPerSconto(p.getSconto());
				}
		}
		model.addAttribute("prodottiScontati", prodottiScontati);
		
		return "indexprova";
	}

}
