package com.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	public List<Etudiant> findByScore(int score);
	public List<Etudiant> findByMalade(boolean m);
	Page<Etudiant> findByMalade(boolean m, Pageable pageable);
	List<Etudiant> findByMaladeAndScoreLessThan(boolean m,int score);
	List<Etudiant> findByMaladeIsTrueAndScoreLessThan(int score);
	List<Etudiant> findByDateNaissanceBetween(Date d1, Date d2);
	List<Etudiant> findByDateNaissanceBetweenAndMaladeIsTrueAndNameLike(Date d1, Date d2,String mc);
	//si vous voulez ajouter des method unique fait ça:
	@Query("select e from Etudiant e where e.dateNaissance between :x and :y or e.name like :z")
	List<Etudiant> chercherEtudiants(@Param("x") Date d1,@Param("y") Date d2,@Param("z") String nom);
	
	@Query("select e from Etudiant e where e.name like :x and e.score < :y")
	List<Etudiant> chercherEtudiants(@Param("x") String nom, @Param("y") int scoreMin);
}
