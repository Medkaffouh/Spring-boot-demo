package com.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.demo.dao.EtudiantRepository;
import com.demo.entities.Etudiant;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	@Autowired
	EtudiantRepository etudiantRepository;

	public static void main(String[] args) {
		/*ApplicationContext context=*/SpringApplication.run(DemoApplication.class, args);
		//EtudiantRepository etudiantRepository=context.getBean(EtudiantRepository.class);
		
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=0;i<100;i++) {
			etudiantRepository.save(new Etudiant(null,"Mohamed","med@gmail.com",new Date(),(int)(Math.random()*100),Math.random()>0.5?true:false));
		}
		
		Page<Etudiant> etuPage = etudiantRepository.findAll(PageRequest.of(1, 5));
		System.out.println("Total pages :"+etuPage.getTotalPages());
		System.out.println("Total elements :"+etuPage.getTotalElements());
		System.out.println("Num Page :"+etuPage.getNumber());
		List<Etudiant> content = etuPage.getContent();
		Page<Etudiant> byMalade = etudiantRepository.findByMalade(true,PageRequest.of(0, 4));
		
		List<Etudiant> etudiantList = etudiantRepository.chercherEtudiants("%h%", 40);
		etudiantList.forEach(et->{
		System.out.println("========================");
		System.out.println(et.getId());
		System.out.println(et.getName());
		System.out.println(et.getEmail());
		System.out.println(et.getDateNaissance());
		System.out.println(et.getScore());
		System.out.println(et.isMalade());
		});
		System.out.println("************************");
		Etudiant et = etudiantRepository.findById(1L).orElse(null); //1L = new Long(1)   //or use .get mais tu dois gére les exceptions
		if(et!=null) {
			System.out.println(et.getName());
			System.out.println(et.isMalade());
		}
		et.setScore(888);
		etudiantRepository.save(et);
		//etudiantRepository.deleteById(1L);
	
		
		/*
		System.out.println("******************************");
		etudiantRepository.findByScore(45).forEach(ett->{
			System.out.println(ett.getName());
			
		});;
		*/
	}

}
