package org.example.Entities;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.*;



@Data
public class Profession implements Serializable ,Comparable<Profession> {
    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    int baseArmor;

    @Getter
    @Setter
    public Set<Character> characters = new TreeSet<>();

    private Profession(ProfessionBuilder professionBuilder)
    {
        this.name= professionBuilder.name;
        this.baseArmor= professionBuilder.baseArmor;
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == null || getClass() != o.getClass()) return false;

        Profession profession =(Profession) o;
        return this.name.equals(profession.name);
    }


    @Override
    public int hashCode(){
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Profession{" +
                "name='" + name + '\'' +
                ", baseArmor=" + baseArmor +
                ", characters=" + characters +
                '}';
    }

    @Override
    public int compareTo(Profession otherProfession) {
        return this.getName().compareTo(otherProfession.getName());
    }

    public void addCharacter(Character newcharacter){
        this.characters.add(newcharacter);
    }

    public static class ProfessionBuilder{
        private String name;
        private int baseArmor;
        private List<Character> characters;


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

