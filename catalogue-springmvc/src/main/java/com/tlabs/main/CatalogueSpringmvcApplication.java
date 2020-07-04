package com.tlabs.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tlabs.main.dao.ProduitRepository;
import com.tlabs.main.entities.Produit;

@SpringBootApplication
public class CatalogueSpringmvcApplication implements CommandLineRunner {

	@Autowired
	ProduitRepository produitRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CatalogueSpringmvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		produitRepository.save(new Produit(null, "PC 5648", 6000, 12));
		produitRepository.save(new Produit(null, "Imprimante HP 1234", 1200, 10));
		produitRepository.save(new Produit(null, "PC Compaq", 9000, 1));
		produitRepository.save(new Produit(null, "Scanner", 1000, 16));
		produitRepository.findAll().forEach(p -> {
			System.out.println(p.getDesignation());
		});
		
	}

}
