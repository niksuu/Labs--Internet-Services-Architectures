package com.example.rpgweapon.Weapon.Entities;


import java.io.Serializable;
import java.util.Comparator;
import java.util.UUID;

import com.example.rpgweapon.Profession.Entities.Profession;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(exclude = "name")
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "weapons")
public class Weapon implements Serializable ,Comparable<Weapon> {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    String name;

    @Column(name = "damage")
    int damage;

    @ManyToOne()
    @JoinColumn(name = "profession_id")
    private Profession profession;



    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", profession=" + profession.getId() +
                '}';
    }

    @Override
    public int compareTo(Weapon otherWeapon) {
        return Comparator.comparing(Weapon::getName)
                .compare(this,otherWeapon);
    }


}
