package fr.uga.projet1.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamLambda {
	
	public static void main(String[] args) {
		
		List<Etudiant> etudiants= new ArrayList<>();
		
		for (int i = 1 ; i<=10;i++)
		{
			etudiants.add(new Etudiant("etu"+i, "prenom"+i, i*2));
			etudiants.add(new Etudiant("etux"+i, "prenomx"+i, i*1.5f));
		}
//		etudiants.forEach(System.out::println);
//		
		System.out.println("________________________TRI__________________");
		
		List<Etudiant> luMoy = etudiants.stream()
				.sorted(Comparator.comparing(Etudiant::getMoyenne))
				.collect(Collectors.toList());
		luMoy.forEach(System.out::println);
		
		System.out.println("________________________nom des étu qui ont la moyenne__________________");
		
		
		List<Etudiant> luMoy2a = etudiants.stream()
				.filter((e)->e.getMoyenne()>=10)
				.collect(Collectors.toList());
		luMoy2a.forEach(System.out::println);

		List<String> luMoy2b = etudiants.stream()
				.filter((e)->e.getMoyenne()>=10)
				.map(Etudiant::getNom)
				.collect(Collectors.toList());
		luMoy2b.forEach(System.out::println);

		String luMoy2c = etudiants.stream()
				.filter((e)->e.getMoyenne()>=10)
				.map(Etudiant::getNom)
				.collect(Collectors.joining(","));
		System.out.println(luMoy2c);

		System.out.println("________________________ moyenne générale__________________");
		
		Double luMoy3 = etudiants.stream()
				.collect(Collectors.averagingDouble(Etudiant::getMoyenne));
		System.out.println(luMoy3);
		
		
		System.out.println("________________________nom de la personne qui a la meilleure moyenne__________________");
		String luMoy4 = etudiants.stream()
		 		.max(Comparator.comparing(Etudiant::getMoyenne))
				.get()
				.getNom();
		System.out.println(luMoy4);

				
		System.out.println("________________________nom des personnes et moyennes__________________");
		Map<Etudiant.Mention, List<Etudiant>> myMap = etudiants.stream()
		 		.collect(Collectors.groupingBy(Etudiant::getMention));
		
		
		myMap.forEach((cle,valeur)->{
			System.out.print(cle + "=");
            valeur.forEach(e->System.out.print(e.getNom()+","));
            System.out.println();		});

				

		
	}

}
