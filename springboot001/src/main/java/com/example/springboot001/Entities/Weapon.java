package com.example.springboot001.Entities;


import jakarta.persistence.*;
import lombok.*;
import java.util.Comparator;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;


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
                ", profession=" + profession.name +
                '}';
    }

    @Override
    public int compareTo(Weapon otherWeapon) {
        return Comparator.comparing(Weapon::getName)
                .compare(this,otherWeapon);
    }


}
