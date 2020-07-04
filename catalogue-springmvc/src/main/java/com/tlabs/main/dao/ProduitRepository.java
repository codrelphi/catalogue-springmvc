package com.tlabs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tlabs.main.entities.Produit;


public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
