package com.example.rpgweapon.Weapon.DTO;



import java.util.List;

import com.example.rpgweapon.Weapon.DTO.Model.WeaponDTO;
import lombok.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetWeaponsResponse {
    @Singular
    private List<WeaponDTO> weapons;
}
