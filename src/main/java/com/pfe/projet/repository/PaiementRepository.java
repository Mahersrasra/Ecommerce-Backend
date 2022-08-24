package com.pfe.projet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pfe.projet.model.Paiement;
@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long>{

}
