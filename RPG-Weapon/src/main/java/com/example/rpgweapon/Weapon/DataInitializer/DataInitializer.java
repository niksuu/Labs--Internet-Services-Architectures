package com.example.rpgweapon.Weapon.DataInitializer;


import com.example.rpgweapon.Profession.Entities.Profession;
import com.example.rpgweapon.Profession.Services.ProfessionService;
import com.example.rpgweapon.Weapon.Entities.Weapon;
import com.example.rpgweapon.Weapon.Services.WeaponService;
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
    private final WeaponService weaponService;


    @Override
    public void afterPropertiesSet() throws Exception {

        Profession profession1 = Profession.builder()
                .id(UUID.fromString("2815a6fc-87de-11ee-b9d1-0242ac120002"))
                .name("Mage")
                .build();

        Profession profession2 =Profession.builder()
                .id(UUID.fromString("564a50e0-87de-11ee-b9d1-0242ac120002"))
                .name("Warrior")
                .build();

        Profession profession3 = Profession.builder()
                .id(UUID.fromString("593765cc-87de-11ee-b9d1-0242ac120002"))
                .name("Archer")
                .build();

        Profession profession4 = Profession.builder()
                .id(UUID.fromString("5cbc8768-87de-11ee-b9d1-0242ac120002"))
                .name("Citizen")
                .build();

        Profession profession5 =Profession.builder()
                .id(UUID.fromString("6039fa38-87de-11ee-b9d1-0242ac120002"))
                .name("Druid")
                .build();

        professionService.saveNewProfession(profession1);
        professionService.saveNewProfession(profession2);
        professionService.saveNewProfession(profession3);
        professionService.saveNewProfession(profession4);
        professionService.saveNewProfession(profession5);



        weaponService.saveNewWeapon(Weapon.builder().profession(profession1).name("Fire-Wand").id(UUID.randomUUID()).damage(65).build());
        weaponService.saveNewWeapon(Weapon.builder().profession(profession1).name("Fire-Orb").id(UUID.randomUUID()).damage(40).build());
        weaponService.saveNewWeapon(Weapon.builder().profession(profession1).name("Dark-Cloak").id(UUID.randomUUID()).damage(15).build());
        weaponService.saveNewWeapon(Weapon.builder().profession(profession2).name("Two-handed-axe").id(UUID.randomUUID()).damage(95).build());
        weaponService.saveNewWeapon(Weapon.builder().profession(profession2).name("One-handed-axe").id(UUID.randomUUID()).damage(55).build());
        weaponService.saveNewWeapon(Weapon.builder().profession(profession2).name("Big Mace").id(UUID.randomUUID()).damage(80).build());
        weaponService.saveNewWeapon(Weapon.builder().profession(profession3).name("Long Bow").id(UUID.randomUUID()).damage(55).build());
        weaponService.saveNewWeapon(Weapon.builder().profession(profession3).name("Fire Crossbow").id(UUID.randomUUID()).damage(65).build());
        weaponService.saveNewWeapon(Weapon.builder().profession(profession4).name("Long Stick").id(UUID.randomUUID()).damage(15).build());

        weaponService.saveNewWeapon(Weapon.builder().profession(profession5).name("Ice-Wand").id(UUID.randomUUID()).damage(45).build());
        weaponService.saveNewWeapon(Weapon.builder().profession(profession5).name("Ice-Orb").id(UUID.randomUUID()).damage(35).build());


        System.out.println(weaponService.findAllWeapons());
        System.out.println(professionService.findAllProfessions());
        System.out.println(weaponService.findByProfessionName("Archer"));



    }


}
