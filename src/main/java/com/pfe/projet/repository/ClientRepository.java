package com.pfe.projet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfe.projet.model.Client;
;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	Optional<Client> findByCode(int id);

	List<Client> findAllByLibelleContaining(String libelle);

	List<Client> findAllByEmail(String email);
	@Query(value = "SELECT count(code) FROM Client")
	public int nbre();

	@Query(value = "SELECT max(code) FROM Client")
	public int max();
}
