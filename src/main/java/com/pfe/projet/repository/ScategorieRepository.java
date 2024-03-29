package com.pfe.projet.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pfe.projet.dto.ListScategorie;
import com.pfe.projet.model.Scategorie;
@Repository
public interface ScategorieRepository extends JpaRepository<Scategorie, Long>{

	Optional<Scategorie> findByCode(String code);

	List<Scategorie> findAllByLibelleContaining(String libelle);

	List<Scategorie> findAllByCcateg(String code);

	@Query(value = "SELECT count(*)  FROM Scategorie   WHERE ccateg  = :code")
	public int nbre (@Param("code") String  code);
	
	@Query(value = "SELECT max(code) FROM Scategorie  where ccateg = :code")
	public int max(@Param("code") String  code);
	
	
	
	@Query(value = "SELECT new com.pfe.projet.dto.ListScategorie (a.code,a.libelle,b.libelle,b.code)  from Scategorie a join Categorie b "
			+ "on a.ccateg = b.code")
	public   List<ListScategorie> listScateg();

}
	