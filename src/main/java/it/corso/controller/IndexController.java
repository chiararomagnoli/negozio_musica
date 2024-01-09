package it.corso.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Categoria;
import it.corso.model.Prodotto;
import it.corso.model.Sottocategoria;
import it.corso.service.CategoriaService;
import it.corso.service.ProdottoService;
import it.corso.service.SottocategoriaService;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private ProdottoService prodottoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private SottocategoriaService sottocategoriaService;

	
	@GetMapping
	public String getPage(Model model) {
		
        List<Prodotto> prodotti = prodottoService.getProdotti();
        // Ordino i prodotti per ID in ordine decrescente
        prodotti.sort(Comparator.comparingLong(Prodotto::getIdProdotto).reversed());
        // aggiungo alla model i prodotti già ordinati
        model.addAttribute("prodotti", prodotti);
		
		model.addAttribute("prodotto", new Prodotto());
		
		List<Prodotto> prodottiUsati = prodottoService.trovamiProdottiPerCondizione("Usato");
		model.addAttribute("prodottiUsati", prodottiUsati);
		
		List<Prodotto> prodottiScontati = new ArrayList<>();
		for(Prodotto p:prodotti) {
			if(p.getSconto()!=0 && !prodottiScontati.contains(p)) {
				prodottiScontati.addAll(prodottoService.trovamiProdottiPerSconto(p.getSconto()));
				}
		}
		
		model.addAttribute("prodottiScontati", prodottiScontati);
		
		List<Categoria> categorie = categoriaService.getCategorie();
		model.addAttribute("categorie", categorie);
		
		
        List<Sottocategoria> sottocategorieChitarre = sottocategoriaService.getSottocategoriaByIdCategoria(1);
        model.addAttribute("sottocategorieChitarre", sottocategorieChitarre);
        List<Sottocategoria> sottocategorieTastiere = sottocategoriaService.getSottocategoriaByIdCategoria(2);
        model.addAttribute("sottocategorieTastiere", sottocategorieTastiere);
        List<Sottocategoria> sottocategorieArchi = sottocategoriaService.getSottocategoriaByIdCategoria(3);
        model.addAttribute("sottocategorieArchi", sottocategorieArchi);
        List<Sottocategoria> sottocategoriePercussioni = sottocategoriaService.getSottocategoriaByIdCategoria(4);
        model.addAttribute("sottocategoriePercussioni", sottocategoriePercussioni);
        List<Sottocategoria> sottocategorieFiati = sottocategoriaService.getSottocategoriaByIdCategoria(5);
        model.addAttribute("sottocategorieFiati", sottocategorieFiati);
           
        

		return "index";
	}

}
