package com.tlabs.main.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tlabs.main.dao.ProduitRepository;
import com.tlabs.main.entities.Produit;

@Controller
public class ProduitController {
	
	@Autowired
	ProduitRepository produitRepository;
	
	@GetMapping(value= {"/", "/index"})
	public String index(Model model) {
		List<Produit> produits = produitRepository.findAll();
		model.addAttribute("produits", produits);
		return "produits";
	}
}
