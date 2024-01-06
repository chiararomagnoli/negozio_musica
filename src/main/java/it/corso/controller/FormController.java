package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Categoria;
import it.corso.model.Prodotto;
import it.corso.model.Sottocategoria;
import it.corso.service.CategoriaService;
import it.corso.service.ProdottoService;
import it.corso.service.SottocategoriaService;

@Controller
@RequestMapping("/form")
public class FormController {
	
	@Autowired
	private ProdottoService prodottoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private SottocategoriaService sottocategoriaService;
	
	@GetMapping
	public String getPage(Model model) {
		List<Prodotto> prodotti = prodottoService.getProdotti();
		model.addAttribute("prodotti", prodotti);
		List<Categoria> categorie = categoriaService.getCategorie();
		model.addAttribute("categorie", categorie);
		List<Sottocategoria> sottocategorie = sottocategoriaService.getSottocategoria();
		model.addAttribute("sottocategorie", sottocategorie);
		return "formprova";
	}	
	
	@GetMapping("/cerca")
    public String cercaProdottiPerNome(@RequestParam("nome") String nome, Model model) {
        List<Prodotto> risultati = prodottoService.cercaProdottiPerNome(nome);
        model.addAttribute("risultati", risultati);
        return "formprova";
    }
	
}
