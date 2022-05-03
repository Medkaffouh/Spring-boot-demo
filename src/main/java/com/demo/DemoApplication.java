package com.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		etudiantRepository.save(new Etudiant(null,"Mohamed","med@gmail.com",new Date(),45));
		etudiantRepository.save(new Etudiant(null,"Hassan","has@gmail.com",new Date(),45));
		etudiantRepository.save(new Etudiant(null,"Mari","mari@gmail.com",new Date(),56));
		
		etudiantRepository.findAll().forEach(et->{
		System.out.println(et.toString());
		});
		System.out.println("---------------------------");
		Etudiant et = etudiantRepository.findById(1L).get();
		System.out.println(et.getName());
		System.out.println("******************************");
		etudiantRepository.findByScore(45).forEach(ett->{
			System.out.println(ett.getName());
		});;
	}

}
