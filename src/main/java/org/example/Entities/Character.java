package org.example.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import java.util.Comparator;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Character implements Serializable ,Comparable<Character> {

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    int level;

    @Getter
    @Setter
    Profession profession;

    public Character(CharacterBuilder characterBuilder)
    {
        this.name= characterBuilder.name;
        this.level=characterBuilder.level;
        this.profession=characterBuilder.profession;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", profession=" + profession.name +
                '}';
    }

    @Override
    public int compareTo(Character othercharacter) {
        return Comparator.comparing(Character::getName)
                .compare(this,othercharacter);
    }

    public static class CharacterBuilder{
        private String name;
        private int level;
        private Profession profession;

        public CharacterBuilder()
        {
        }


        public CharacterBuilder profession(Profession profession)
        {
            this.profession=profession;
            return this;
        }
        public CharacterBuilder name(String name)
        {
            this.name=name;
            return this;
        }

        public CharacterBuilder level(int level)
        {
            this.level=level;
            return this;
        }



        public Character build()
        {
            return new Character(this);
        }
    }

}
