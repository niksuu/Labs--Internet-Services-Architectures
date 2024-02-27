package com.example.rpgweapon.Weapon.DataInitializer;


import com.example.rpgweapon.Profession.Entities.Profession;
import com.example.rpgweapon.Profession.Services.ProfessionService;
import com.example.rpgweapon.Weapon.Entities.Weapon;
import com.example.rpgweapon.Weapon.Services.WeaponService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;


@Component
public class CommandLine implements CommandLineRunner
{

    private final Scanner scanner = new Scanner(System.in);
    //List<String> Weaponnames = List.of("Fire-Orb", "Fire-Wand", "Ice-Wand", "Ice-Orb", "Two-handed axe", "One-Handed axe", "Long Sword", "Long Bow", "Stick", "Fire Crossbow", "Quiver", "Big Mace", "Big-Tome", "Knife", "Halberd");
    //List<String> Professionnames = List.of("Mage", "Warrior", "Archer", "Citizen", "Druid");

    private final ProfessionService professionService;
    private final WeaponService weaponService;

    public CommandLine(ProfessionService professionService, WeaponService weaponService) {
        this.professionService = professionService;
        this.weaponService = weaponService;
    }


    private void showCommands() {
        System.out.println("Available commands:");
        System.out.println("1 - Show available commands");
        System.out.println("2 - List all categories");
        System.out.println("3 - List all elements");
        System.out.println("4 - Add a new element");
        System.out.println("5 - Delete an existing element");
        System.out.println("6 - Stop the application");
    }

    private void listCommands() {
        showCommands();
    }

    private void listCategories() {
        System.out.println("Available categories:");
        professionService.findAllProfessions().forEach(profession -> System.out.println(profession.toString()));
    }

    private void listElements() {
        System.out.println("Available elements:");
        weaponService.findAllWeapons().forEach(weapon -> System.out.println(weapon.toString()));
    }

    private void addElement() {
        scanner.nextLine();
        System.out.print("Enter element name: ");
        String elementName = scanner.nextLine();
        System.out.print("Enter element damage: ");
        int elementDamage = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Enter category name: ");
        String Uuid_number = scanner.nextLine();

        Optional<Profession> optionalProfession = professionService.findProfessionById(UUID.fromString(Uuid_number));
        if (optionalProfession.isEmpty()) {
            System.out.println("Category not found.");
            return;
        }

        Profession profession = optionalProfession.get();

        weaponService.saveNewWeapon(Weapon.builder().profession(profession).name(elementName).id(UUID.randomUUID()).damage(elementDamage).build());
        System.out.println("Element added successfully.");
    }

    private void deleteElement() {
        scanner.nextLine();
        System.out.print("Enter element name to delete: ");
        String elementName = scanner.nextLine();
        Optional<Weapon> OptionalweaponToDelete = weaponService.findByName(elementName);

        Weapon weaponToDelete=OptionalweaponToDelete.get();

        if (weaponToDelete == null) {
            System.out.println("Element not found.");
            return;
        }

        weaponService.deleteWeaponById(weaponToDelete.getId());
        System.out.println("Element deleted successfully.");
    }

    public void Commandline()
    {
        while (true) {
            System.out.print("Enter command: ");
            Integer point = scanner.nextInt();
            switch (point) {
                case 1:
                    listCommands();
                    break;
                case 2:
                    listCategories();
                    break;
                case 3:
                    listElements();
                    break;
                case 4:
                    addElement();
                    break;
                case 5:
                    deleteElement();
                    break;
                case 6:
                    System.out.println("Stopping the application.");
                    System.exit(0);
                default:
                    System.out.println("Unknown command. Type 'list' to see available commands.");
            }
        }
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("TEST");
        Commandline();
    }
}
