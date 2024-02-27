package com.example.springboot001.DataInitializer;

import com.example.springboot001.Entities.Profession;
import com.example.springboot001.Entities.Weapon;
import com.example.springboot001.Services.ProfessionService;
import com.example.springboot001.Services.WeaponService;
import com.example.springboot001.Springboot001Application;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer implements InitializingBean {

    private final Scanner scanner = new Scanner(System.in);
    //List<String> Weaponnames = List.of("Fire-Orb", "Fire-Wand", "Ice-Wand", "Ice-Orb", "Two-handed axe", "One-Handed axe", "Long Sword", "Long Bow", "Stick", "Fire Crossbow", "Quiver", "Big Mace", "Big-Tome", "Knife", "Halberd");
    //List<String> Professionnames = List.of("Mage", "Warrior", "Archer", "Citizen", "Druid");

    private final ProfessionService professionService;
    private final WeaponService weaponService;


    @Override
    public void afterPropertiesSet() throws Exception {

        professionService.saveNewProfession(Profession.builder().name("Mage").id(UUID.randomUUID()).baseArmor(30).build());
        professionService.saveNewProfession(Profession.builder().name("Warrior").id(UUID.randomUUID()).baseArmor(70).build());
        professionService.saveNewProfession(Profession.builder().name("Druid").id(UUID.randomUUID()).baseArmor(45).build());
        professionService.saveNewProfession(Profession.builder().name("Citizen").id(UUID.randomUUID()).baseArmor(15).build());
        professionService.saveNewProfession(Profession.builder().name("Archer").id(UUID.randomUUID()).baseArmor(50).build());


        for (Profession pr : professionService.findAllProfessions()) {
            switch (pr.getName()) {
                case "Mage":
                    weaponService.saveNewWeapon(Weapon.builder().profession(pr).name("Fire-Wand").id(UUID.randomUUID()).damage(65).build());
                    weaponService.saveNewWeapon(Weapon.builder().profession(pr).name("Fire-Orb").id(UUID.randomUUID()).damage(40).build());
                    weaponService.saveNewWeapon(Weapon.builder().profession(pr).name("Dark-Cloak").id(UUID.randomUUID()).damage(15).build());
                    break;
                case "Warrior":
                    weaponService.saveNewWeapon(Weapon.builder().profession(pr).name("Two-handed-axe").id(UUID.randomUUID()).damage(95).build());
                    weaponService.saveNewWeapon(Weapon.builder().profession(pr).name("One-handed-axe").id(UUID.randomUUID()).damage(55).build());
                    weaponService.saveNewWeapon(Weapon.builder().profession(pr).name("Big Mace").id(UUID.randomUUID()).damage(80).build());
                    break;
                case "Archer":
                    weaponService.saveNewWeapon(Weapon.builder().profession(pr).name("Long Bow").id(UUID.randomUUID()).damage(55).build());
                    weaponService.saveNewWeapon(Weapon.builder().profession(pr).name("Fire Crossbow").id(UUID.randomUUID()).damage(65).build());
                    break;
                case "Citizen":
                    weaponService.saveNewWeapon(Weapon.builder().profession(pr).name("Long Stick").id(UUID.randomUUID()).damage(15).build());
                    break;
                case "Druid":
                    weaponService.saveNewWeapon(Weapon.builder().profession(pr).name("Ice-Wand").id(UUID.randomUUID()).damage(45).build());
                    weaponService.saveNewWeapon(Weapon.builder().profession(pr).name("Ice-Orb").id(UUID.randomUUID()).damage(35).build());
                    break;

            }
        }

        System.out.println(weaponService.findAllWeapons());
        System.out.println(professionService.findAllProfessions());
        System.out.println(weaponService.findByProfessionName("Archer"));



    }


}
