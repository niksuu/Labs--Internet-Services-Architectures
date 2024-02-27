package com.example.rpgprofession.Profession.Entity;

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

    @Column(name = "baseArmor")
    int baseArmor;


    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", baseArmor=" + baseArmor +
                '}';
    }

    @Override
    public int compareTo(Profession otherProfession) {
        return this.getName().compareTo(otherProfession.getName());
    }



}

