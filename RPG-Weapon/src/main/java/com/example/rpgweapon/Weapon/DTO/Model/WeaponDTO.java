package com.example.rpgweapon.Weapon.DTO.Model;

import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(exclude = "name")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class WeaponDTO {

    private UUID id;
    private String name;
    private int damage;
    private UUID professionUUID;

}
