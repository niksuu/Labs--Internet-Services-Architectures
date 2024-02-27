package com.example.springboot001.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.*;



@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="professions")
public class Profession implements Serializable ,Comparable<Profession> {


    @Id
    private UUID id;

    String name;
    int baseArmor;

    @OneToMany(mappedBy = "profession",fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    public Set<Weapon> Weapons = new TreeSet<>();


    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", baseArmor=" + baseArmor +
                ", Weapons=" + Weapons +
                '}';
    }

    @Override
    public int compareTo(Profession otherProfession) {
        return this.getName().compareTo(otherProfession.getName());
    }

    public void addWeapon(Weapon newWeapon){
        this.Weapons.add(newWeapon);
    }

}

