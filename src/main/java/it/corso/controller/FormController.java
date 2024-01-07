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
		List<Prodotto> prodotti = prodottoService.ordinaProdottiPerNome();
		model.addAttribute("prodotti", prodotti);
		return "formprova";
	}	
	
	@GetMapping("/cerca")
    public String cercaProdottiPerNome(@RequestParam("nome") String nome, 
    		@RequestParam(name = "nomeCategoria", required = false) String nomeCategoria, 
    		Model model) {
        List<Prodotto> risultati;
        
        if ((nome != null && !nome.isEmpty()) || (nomeCategoria != null && !nomeCategoria.isEmpty())) {
            // Se è stato specificato un nome, ottieni i prodotti per quel nome
            risultati = prodottoService.cercaProdottiPerNome(nome);
            // Se è stato specificato un nome di categoria, ottieni i prodotti per quel nome di categoria
            if (nomeCategoria != null && !nomeCategoria.isEmpty()) {
                List<Prodotto> risultatiCategoria = prodottoService.cercaProdottiPerNomeCategoria(nomeCategoria);
                risultati.addAll(risultatiCategoria); // Aggiungi i risultati della ricerca per categoria
            }
        } else {
            // Se non è stato specificato un nome di categoria, ottieni tutti i prodotti
            risultati = prodottoService.getProdotti();
        }
        model.addAttribute("risultati", risultati);
        	    
	    List<Categoria> categorie = categoriaService.getCategorie();
	    model.addAttribute("categorie", categorie);
	    List<Sottocategoria> sottocategorie = sottocategoriaService.getSottocategoria();
	    model.addAttribute("sottocategorie", sottocategorie);
        return "formprova";
    }
	
}
