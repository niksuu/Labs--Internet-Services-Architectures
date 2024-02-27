package org.example.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.*;



@Entity
@EqualsAndHashCode(exclude = "name")
@ToString
public class Profession implements Serializable ,Comparable<Profession> {
    @Getter
    @Setter
    @Id
    String name;

    @Getter
    @Setter
    int baseArmor;

    @Getter
    @Setter
    public Set<Weapon> Weapons = new TreeSet<>();

    private Profession(ProfessionBuilder professionBuilder)
    {
        this.name= professionBuilder.name;
        this.baseArmor= professionBuilder.baseArmor;
    }


    @Override
    public int compareTo(Profession otherProfession) {
        return this.getName().compareTo(otherProfession.getName());
    }

    public void addWeapon(Weapon newWeapon){
        this.Weapons.add(newWeapon);
    }

    public static class ProfessionBuilder{
        private String name;
        private int baseArmor;
        private List<Weapon> Weapons;


        public ProfessionBuilder name(String name){
            this.name = name;
            return this;
        }

        public ProfessionBuilder baseArmor(int baseArmor) {
            this.baseArmor=baseArmor;
            return this;
        }

        public Profession build() {
            return new Profession(this);
        }
    }
}

