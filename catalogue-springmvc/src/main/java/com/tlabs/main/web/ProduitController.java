package com.tlabs.main.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tlabs.main.dao.ProduitRepository;
import com.tlabs.main.entities.Produit;

@Controller
public class ProduitController {
	
	@Autowired
	ProduitRepository produitRepository;
	
	@GetMapping(value= {"/", "/index"})
	public String chercher(Model model, 
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="motCle", defaultValue="") String mc) {
		//List<Produit> produits = produitRepository.findAll();
		//Page<Produit> pageProduits = produitRepository.findAll(PageRequest.of(page, 10));
		Page<Produit> pageProduits = produitRepository.findByDesignationContains(mc, PageRequest.of(page, 10));
		model.addAttribute("produits", pageProduits.getContent());
		model.addAttribute("pages", new int[pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "produits";
	}
	
	
}
