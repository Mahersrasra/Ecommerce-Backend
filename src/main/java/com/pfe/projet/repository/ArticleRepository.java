package com.pfe.projet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfe.projet.dto.ListArticle;
import com.pfe.projet.model.Article;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

	

	Optional<Article> findByCode(String code);

	List<Article> findAllByLibelleContaining(String libelle);
	List<Article> findAllByCcateg(String code);

	List<Article> findAllByCscateg(String code);
	
	@Query(value = "SELECT new com.pfe.projet.dto.ListArticle (a.id,a.code,a.libelle,b.libelle,c.libelle,d.name,a.pa,a.pv,a.tva,a.stock,a.sexe,a.taille)"
			+ " from Article a, Categorie b, Scategorie c, Boutique d  where a.ccateg = b.code and a.cscateg = c.code and a.codeBoutique = d.code")
	List<ListArticle> listArticle();
	
	@Query(value = "SELECT new com.pfe.projet.dto.ListArticle (a.id,a.code,a.libelle,b.libelle,c.libelle,d.name,a.pa,a.pv,a.tva,a.stock,a.sexe,a.taille)"
			+ " from Article a, Categorie b, Scategorie c, Boutique d  where a.ccateg = b.code and a.cscateg = c.code and a.codeBoutique = d.code"
			+ " and  d.code  = :code")
	List<ListArticle> listArticleBoutique(@Param("code") int  code);
	

	@Query(value = "SELECT count(*)  FROM Article   WHERE cscateg  = :code")
	public int nbre (@Param("code") String  code);
	
	@Query(value = "SELECT max(code) FROM Article  where cscateg = :code")
	public int max(@Param("code") String  code);

	Optional<Article> findAllById(Long id);
	@Query(value = "SELECT new com.pfe.projet.dto.ListArticle (a.id,a.code,a.libelle,b.libelle,c.libelle,d.name,a.pa,a.pv,a.tva,a.stock,a.sexe,a.taille)"
			+ " from Article a, Categorie b, Scategorie c, Boutique d  where a.ccateg = b.code and a.cscateg = c.code and a.codeBoutique = d.code"
			+ " and  a.sexe  = :sexe")
	List<ListArticle> listSexe(@Param("sexe") String sexe);

	@Query(value = "SELECT new com.pfe.projet.dto.ListArticle (a.id,a.code,a.libelle,b.libelle,c.libelle,d.name,a.pa,a.pv,a.tva,a.stock,a.sexe,a.taille)"
			+ " from Article a, Categorie b, Scategorie c, Boutique d  where a.ccateg = b.code and a.cscateg = c.code and a.codeBoutique = d.code"
			+ " and  a.ccateg = :code")
	List<ListArticle> listShoes(@Param("code") String  code);
}
	