package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.service.CategoriaService;
import it.corso.service.SottocategoriaService;

@Controller
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	SottocategoriaService sottocategoriaService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping
	public String getPage(Model model) {
		//model utili per la navbar
		model.addAttribute("sottocategorie", sottocategoriaService.getSottocategoria());
		model.addAttribute("categorie", categoriaService.getCategorie());
		model.addAttribute("sottocategorieChitarre", sottocategoriaService.getSottocategoriaByIdCategoria(1));
		model.addAttribute("sottocategorieTastiere", sottocategoriaService.getSottocategoriaByIdCategoria(2));
		model.addAttribute("sottocategorieArchi", sottocategoriaService.getSottocategoriaByIdCategoria(3));
		model.addAttribute("sottocategoriePercussioni", sottocategoriaService.getSottocategoriaByIdCategoria(4));
		model.addAttribute("sottocategorieFiati", sottocategoriaService.getSottocategoriaByIdCategoria(5));
		return "info";
	}
}
