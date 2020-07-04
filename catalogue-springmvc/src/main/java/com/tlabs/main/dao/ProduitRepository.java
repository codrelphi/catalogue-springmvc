package com.tlabs.main.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tlabs.main.entities.Produit;


public interface ProduitRepository extends JpaRepository<Produit, Long> {

	public Page<Produit> findByDesignationContains(String mc, Pageable pageable);
}
