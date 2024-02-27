package com.example.rpgweapon.Profession.Entities;

import com.example.rpgweapon.Weapon.Entities.Weapon;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name="professions")
public class Profession implements Serializable ,Comparable<Profession> {


    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name",unique = true)
    String name;



    @OneToMany(mappedBy = "profession",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    public Set<Weapon> Weapons = new TreeSet<>();


    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Weapons=" + Weapons +
                '}';
    }

    @Override
    public int compareTo(Profession otherProfession) {
        return this.getName().compareTo(otherProfession.getName());
    }


}

