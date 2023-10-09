package org.example;

import org.example.Entities.*;
import org.example.Entities.Character;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {




    public static void main(String[] args) {
         List<String> Characternames = List.of("Xardas","Torus","Corristo","Gomez","Vatras","Bennet","Pedro","Xavier","Maurus","Diego","Sentezna","Raul","Valar","Balar","Milten","Vasquez");
         List<String> Professionnames = List.of("Mage","Warrior","Archer","Citizen","Druid");

         //1
        Set<Profession> professions = new TreeSet<>();
        Random rand=new Random();

        professions.add(new Profession.ProfessionBuilder().name("Mage").baseArmor(30).build());
        professions.add(new Profession.ProfessionBuilder().name("Warrior").baseArmor(70).build());
        professions.add(new Profession.ProfessionBuilder().name("Druid").baseArmor(45).build());
        professions.add(new Profession.ProfessionBuilder().name("Citizen").baseArmor(15).build());
        professions.add(new Profession.ProfessionBuilder().name("Archer").baseArmor(50).build());



        for(Profession pr: professions) {
            for(int i=0; i < rand.nextInt(3) + 1; i++){
                pr.addCharacter(new Character.CharacterBuilder().profession(pr).name(Characternames.get(rand.nextInt(Characternames.size()))).level(rand.nextInt(99) + 1).build());
            }
        }

        //2
      // professions.forEach(profession -> {
      //     System.out.println("Profession: " + profession.getName() + ", Base Armor: " + profession.getBaseArmor());
      //     profession.getCharacters().forEach(character -> {
      //         System.out.println("   Character: " + character.getName() + ", Level: " + character.getLevel());
      //     });
      // });

        //3
        List<Character> characters = professions.stream()
                .map(Profession::getCharacters)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        //characters.forEach(System.out::println);

        //4
        List<Character> lowCharacters = characters.stream()
                .filter(character -> character.getLevel() <= 50)
                .sorted((c1, c2) -> Integer.compare(c1.getLevel(), c2.getLevel()))
                .collect(Collectors.toList());

        //lowCharacters.forEach(System.out::println);

        //5
        List<CharacterDto> charactersDtos = lowCharacters.stream()
                .map(c -> new CharacterDto.CharacterDtoBuilder().profession(c.getProfession().toString()).name(c.getName()).level(c.getLevel()).build())
                .sorted((c1, c2) -> Integer.compare(c1.getLevel(), c2.getLevel()))
                .collect(Collectors.toList());
        //charactersDtos.forEach(System.out::println);


        //6 saving coletction
         Main.saveToFile("test.txt",professions);

         // reading colection
        Set<Profession> readedprofessions = Main.readFromFile("test.txt");

       //readedprofessions.forEach(profession -> {
       //    System.out.println("Profession: " + profession.getName() + ", Base Armor: " + profession.getBaseArmor());
       //    profession.getCharacters().forEach(character -> {
       //        System.out.println("   Character: " + character.getName() + ", Level: " + character.getLevel());
       //    });
       //});


        //7
        // Zdefiniuj niestandardowy basen wątków ForkJoinPool
       //ForkJoinPool customThreadPool = new ForkJoinPool(4); // Ustaw rozmiar basenu wątków
       //// Wykonaj zadanie dla każdej kategorii z użyciem równoległego strumienia
       //professions.parallelStream().forEach(profession -> {
       //    // Zadanie do wykonania (na przykład, drukowanie elementów z przerwami)
       //    profession.getCharacters().forEach(character -> {
       //        try {
       //            System.out.println("Category: " + profession.getName() + ", Character: " +
       //                    character.getName() + ", Level: " + character.getLevel());
       //            // Symulacja obciążenia za pomocą przerwy
       //            Thread.sleep(1500);
       //        } catch (InterruptedException e) {
       //            e.printStackTrace();
       //        }
       //    });
       //});
       //// Zamknij niestandardowy basen wątków
       //customThreadPool.shutdown();





    }
    private static void saveToFile(String fileName, Set<Profession> professions) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(professions);
            System.out.println("Saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<Profession> readFromFile(String fileName) {
        Set<Profession> professions = new HashSet<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            professions = (Set<Profession>) ois.readObject();
            System.out.println("Read from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return professions;
    }

}