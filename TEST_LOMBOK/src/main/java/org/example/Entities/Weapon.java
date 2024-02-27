package org.example.Entities;


import lombok.*;
import java.util.Comparator;
import java.io.Serializable;
import java.util.Objects;

@Data
@EqualsAndHashCode(exclude = "name")
public class Weapon implements Serializable ,Comparable<Weapon> {

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    int damage;

    @Getter
    @Setter
    Profession profession;

    public Weapon(WeaponBuilder WeaponBuilder)
    {
        this.name= WeaponBuilder.name;
        this.damage=WeaponBuilder.damage;
        this.profession=WeaponBuilder.profession;
    }


    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", profession=" + profession.name +
                '}';
    }

    @Override
    public int compareTo(Weapon otherWeapon) {
        return Comparator.comparing(Weapon::getName)
                .compare(this,otherWeapon);
    }

    public static class WeaponBuilder{
        private String name;
        private int damage;
        private Profession profession;

        public WeaponBuilder()
        {
        }


        public WeaponBuilder profession(Profession profession)
        {
            this.profession=profession;
            return this;
        }
        public WeaponBuilder name(String name)
        {
            this.name=name;
            return this;
        }

        public WeaponBuilder damage(int damage)
        {
            this.damage=damage;
            return this;
        }



        public Weapon build()
        {
            return new Weapon(this);
        }
    }

}
