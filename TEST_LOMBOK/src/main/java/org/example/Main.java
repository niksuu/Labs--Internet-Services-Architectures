package org.example;

import org.example.Entities.*;
import org.example.Entities.Weapon;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace Weapons in your code.

public class Main {




    public static void main(String[] args) {
         List<String> Weaponnames = List.of("Fire-Orb","Fire-Wand","Ice-Wand","Ice-Orb","Two-handed axe","One-Handed axe","Long Sword","Long Bow","Stick","Fire Crossbow","Quiver","Big Mace","Big-Tome","Knife","Halberd");
         List<String> Professionnames = List.of("Mage","Warrior","Archer","Citizen","Druid");

         //1
        Set<Profession> professions = new TreeSet<>();
        Random rand=new Random();

        professions.add(new Profession.ProfessionBuilder().name("Mage").baseArmor(30).build());
        professions.add(new Profession.ProfessionBuilder().name("Warrior").baseArmor(70).build());
        professions.add(new Profession.ProfessionBuilder().name("Druid").baseArmor(45).build());
        professions.add(new Profession.ProfessionBuilder().name("Citizen").baseArmor(15).build());
        professions.add(new Profession.ProfessionBuilder().name("Archer").baseArmor(50).build());



        for(Profession pr:professions)
        {
            switch (pr.getName()){
                case "Mage":
                    pr.addWeapon(new Weapon.WeaponBuilder().profession(pr).name("Fire-Wand").damage(65).build());
                    pr.addWeapon(new Weapon.WeaponBuilder().profession(pr).name("Fire-Orb").damage(40).build());
                    pr.addWeapon(new Weapon.WeaponBuilder().profession(pr).name("Dark-Cloak").damage(15).build());
                    break;
                case "Warrior":
                    pr.addWeapon(new Weapon.WeaponBuilder().profession(pr).name("Two-handed-axe").damage(95).build());
                    pr.addWeapon(new Weapon.WeaponBuilder().profession(pr).name("One-handed-axe").damage(55).build());
                    pr.addWeapon(new Weapon.WeaponBuilder().profession(pr).name("Big Mace").damage(80).build());
                    break;
                case "Archer":
                    pr.addWeapon(new Weapon.WeaponBuilder().profession(pr).name("Long Bow").damage(55).build());
                    pr.addWeapon(new Weapon.WeaponBuilder().profession(pr).name("Fire Crossbow").damage(65).build());
                    break;
                case "Citizen":
                    pr.addWeapon(new Weapon.WeaponBuilder().profession(pr).name("Long Stick").damage(15).build());
                    break;
                case "Druid":
                    pr.addWeapon(new Weapon.WeaponBuilder().profession(pr).name("Ice-Wand").damage(45).build());
                    pr.addWeapon(new Weapon.WeaponBuilder().profession(pr).name("Ice-Orb").damage(35).build());
                    break;
            }
        }

       // for(Profession pr: professions) {
       //     for(int i=0; i < rand.nextInt(3) + 1; i++){
       //         pr.addWeapon(new Weapon.WeaponBuilder().profession(pr).name(Weaponnames.get(rand.nextInt(Weaponnames.size()))).damage(rand.nextInt(99) + 1).build());
       //     }
       // }

        //2
       professions.forEach(profession -> {
           System.out.println("Profession: " + profession.getName() + ", Base Armor: " + profession.getBaseArmor());
           profession.getWeapons().forEach(Weapon -> {
               System.out.println("   Weapon: " + Weapon.getName() + ", damage: " + Weapon.getDamage());
           });
       });

        //3
        List<Weapon> Weapons = professions.stream()
                .map(Profession::getWeapons)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        //Weapons.forEach(System.out::println);

        //4
        List<Weapon> lowWeapons = Weapons.stream()
                .filter(weapon -> weapon.getDamage() <= 50)
                .sorted((c1, c2) -> Integer.compare(c1.getDamage(), c2.getDamage()))
                .collect(Collectors.toList());

        //lowWeapons.forEach(System.out::println);

        //5
        List<WeaponDto> WeaponsDtos = lowWeapons.stream()
                .map(c -> new WeaponDto.WeaponDtoBuilder().profession(c.getProfession().toString()).name(c.getName()).damage(c.getDamage()).build())
                .sorted((c1, c2) -> Integer.compare(c1.getDamage(), c2.getDamage()))
                .collect(Collectors.toList());
        //WeaponsDtos.forEach(System.out::println);


        //6 saving coletction
         Main.saveToFile("test.txt",professions);

         // reading colection
        Set<Profession> readedprofessions = Main.readFromFile("test.txt");

       //readedprofessions.forEach(profession -> {
       //    System.out.println("Profession: " + profession.getName() + ", Base Armor: " + profession.getBaseArmor());
       //    profession.getWeapons().forEach(Weapon -> {
       //        System.out.println("   Weapon: " + Weapon.getName() + ", damage: " + Weapon.getDamage());
       //    });
       //});


        //7

        ExecutorService customThreadPool = Executors.newFixedThreadPool(4);

        customThreadPool.submit(() -> {
            professions.parallelStream().forEach(profession -> {
                profession.getWeapons().forEach(weapon -> {
                    try {
                        System.out.println("Category: " + profession.getName() + ", Weapon: " +
                                weapon.getName() + ", damage: " + weapon.getDamage());
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            });
        });
       customThreadPool.shutdown();





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