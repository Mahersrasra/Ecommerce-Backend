package com.pfe.projet.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.pfe.projet.model.Carte;

@Repository
public interface CarteRepository extends JpaRepository<Carte, Long>{

	Optional<Carte> findByNumCarte(String numCarte);

	

}