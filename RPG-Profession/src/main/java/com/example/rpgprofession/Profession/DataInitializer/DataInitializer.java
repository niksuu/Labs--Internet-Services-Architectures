package com.example.rpgprofession.Profession.DataInitializer;


import com.example.rpgprofession.Profession.Entity.Profession;
import com.example.rpgprofession.Profession.Service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer implements InitializingBean {

    private final Scanner scanner = new Scanner(System.in);
    //List<String> Weaponnames = List.of("Fire-Orb", "Fire-Wand", "Ice-Wand", "Ice-Orb", "Two-handed axe", "One-Handed axe", "Long Sword", "Long Bow", "Stick", "Fire Crossbow", "Quiver", "Big Mace", "Big-Tome", "Knife", "Halberd");
    //List<String> Professionnames = List.of("Mage", "Warrior", "Archer", "Citizen", "Druid");

    private final ProfessionService professionService;
    //private final WeaponService weaponService;


    @Override
    public void afterPropertiesSet() throws Exception {

        professionService.saveNewProfession(Profession.builder().name("Mage").id(UUID.fromString("2815a6fc-87de-11ee-b9d1-0242ac120002")).baseArmor(30).build());
        professionService.saveNewProfession(Profession.builder().name("Warrior").id(UUID.fromString("564a50e0-87de-11ee-b9d1-0242ac120002")).baseArmor(70).build());
        professionService.saveNewProfession(Profession.builder().name("Archer").id(UUID.fromString("593765cc-87de-11ee-b9d1-0242ac120002")).baseArmor(45).build());
        professionService.saveNewProfession(Profession.builder().name("Citizen").id(UUID.fromString("5cbc8768-87de-11ee-b9d1-0242ac120002")).baseArmor(15).build());
        professionService.saveNewProfession(Profession.builder().name("Druid").id(UUID.fromString("6039fa38-87de-11ee-b9d1-0242ac120002")).baseArmor(50).build());




    }


}
