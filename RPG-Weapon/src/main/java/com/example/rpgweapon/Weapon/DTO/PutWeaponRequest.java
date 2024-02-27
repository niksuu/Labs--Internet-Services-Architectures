package com.example.rpgweapon.Weapon.DTO;

import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PutWeaponRequest {
    private String name;
    private int damage;
    private UUID profession;
}
