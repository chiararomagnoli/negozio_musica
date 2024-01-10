package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Prodotto;
import it.corso.service.CategoriaService;
import it.corso.service.ProdottoService;
import it.corso.service.SottocategoriaService;

@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {
	
	@Autowired
	private ProdottoService prodottoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private SottocategoriaService sottocategoriaService;
	
	
	@GetMapping
	public String getPage(@RequestParam(name="id", required=true) int id, Model model) {
		List<Prodotto> prodotti = prodottoService.getProdotti();
		model.addAttribute("prodotto", prodotti.get(id-1));
		model.addAttribute("categorie", categoriaService.getCategorie());
		model.addAttribute("sottocategorie", sottocategoriaService.getSottocategoria());
		model.addAttribute("sottocategorie", sottocategoriaService.getSottocategoria());
		model.addAttribute("categorie", categoriaService.getCategorie());
        model.addAttribute("sottocategorieChitarre", sottocategoriaService.getSottocategoriaByIdCategoria(1));
        model.addAttribute("sottocategorieTastiere", sottocategoriaService.getSottocategoriaByIdCategoria(2));
        model.addAttribute("sottocategorieArchi", sottocategoriaService.getSottocategoriaByIdCategoria(3));
        model.addAttribute("sottocategoriePercussioni", sottocategoriaService.getSottocategoriaByIdCategoria(4));
        model.addAttribute("sottocategorieFiati", sottocategoriaService.getSottocategoriaByIdCategoria(5));
		return "dettaglio";
	}

}
