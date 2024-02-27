package com.example.rpgweapon.Weapon.DTO;

import java.util.UUID;
import lombok.*;
@EqualsAndHashCode(exclude = "name")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class GetWeaponResponse {
    private UUID id;
    private String name;
    private int damage;
    private UUID profession;
}
