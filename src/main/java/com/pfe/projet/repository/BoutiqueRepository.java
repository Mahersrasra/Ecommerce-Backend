package com.pfe.projet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfe.projet.model.Boutique;

@Repository
public interface BoutiqueRepository extends JpaRepository<Boutique, Long>{

	Optional<Boutique> findByCode(String code);

	List<Boutique> findAllByNameContaining(String libelle);
	@Query(value = "SELECT count(code) FROM Boutique")
	public int nbre();

	@Query(value = "SELECT max(code) FROM Boutique")
	public int max();
	

} 