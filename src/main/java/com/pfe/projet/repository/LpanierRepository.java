package com.pfe.projet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfe.projet.model.Lpanier;

@Repository
public interface LpanierRepository extends JpaRepository<Lpanier, Long>{

	

}
