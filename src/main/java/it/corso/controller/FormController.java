package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Categoria;
import it.corso.model.Marca;
import it.corso.model.Prodotto;
import it.corso.model.Sottocategoria;
import it.corso.service.CategoriaService;
import it.corso.service.MarcaService;
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
	
	@Autowired
	private MarcaService marcaService;

	
	@GetMapping
	public String getPage(Model model) {
		List<Prodotto> prodotti = prodottoService.ordinaProdottiPerNome();
		model.addAttribute("prodotti", prodotti);
		List<Categoria> categorie = categoriaService.getCategorie();
	    model.addAttribute("categorie", categorie);
	    List<Sottocategoria> sottocategorie = sottocategoriaService.getSottocategoria();
	    model.addAttribute("sottocategorie", sottocategorie);
	    List<Marca> marche = marcaService.getMarche();
	    model.addAttribute("marche", marche);
		return "lista_strumenti";
	}	
	
	@GetMapping("/cerca")
    public String formManager(
    		@RequestParam(name="marca", required=false) Integer idMarca, 
    		@RequestParam(name = "categoria", required = false) Integer idCategoria,
    		@RequestParam(name="sottocategoria", required=false) Integer idSottocategoria,
    		@RequestParam(name="condizione", required=false) String condizione,
    		Model model) {
        List<Prodotto> risultati=prodottoService.getProdotti(
        		idMarca==null? 0: idMarca.intValue(), 
        		idCategoria==null? 0:idCategoria.intValue(), 
        		idSottocategoria==null? 0:idSottocategoria.intValue(), 
        		condizione);
        model.addAttribute("prodotti", risultati);
        List<Categoria> categorie = categoriaService.getCategorie();
	    model.addAttribute("categorie", categorie);
	    
	    List<Sottocategoria> sottocategorie = sottocategoriaService.getSottocategoriaByIdCategoria(idCategoria==null? 0:idCategoria.intValue());
	    model.addAttribute("sottocategorie", sottocategorie);
	    List<Marca> marche = marcaService.getMarche();
	    model.addAttribute("marche", marche);
        return "lista_strumenti";
	}
	
}
