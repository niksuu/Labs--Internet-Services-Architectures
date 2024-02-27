package com.example.rpgweapon.Weapon.Mappers;


import com.example.rpgweapon.Profession.Entities.Profession;
import com.example.rpgweapon.Weapon.DTO.GetWeaponResponse;
import com.example.rpgweapon.Weapon.DTO.Model.WeaponDTO;
import com.example.rpgweapon.Weapon.DTO.PutWeaponRequest;
import com.example.rpgweapon.Weapon.Entities.Weapon;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper
public interface WeaponMapper {
    Weapon WeaponDtoToWeapon(WeaponDTO weaponDTO);


    default WeaponDTO WeaponToWeaponDto(Weapon weapon)
    {
        if(weapon== null){
            return null;
        }
        return WeaponDTO.builder()
                .id(weapon.getId())
                .name(weapon.getName())
                .damage(weapon.getDamage())
                .professionUUID(weapon.getProfession().getId())
                .build();
    }

    default GetWeaponResponse WeaponToGetWeaponResponse(Weapon weapon)
    {
        if(weapon== null){
            return null;
        }
        return GetWeaponResponse.builder()
                .id(weapon.getId())
                .name(weapon.getName())
                .damage(weapon.getDamage())
                .profession(weapon.getProfession().getId())
                .build();
    }

    default Weapon putWeaponRequestToProfession(UUID uuid, PutWeaponRequest putWeaponRequest) {
        if (putWeaponRequest == null) {
            return null;
        }
        return Weapon.builder().id(uuid)
                                .name(putWeaponRequest.getName())
                                .damage(putWeaponRequest.getDamage())
                                .profession(Profession.builder()
                                        .id(putWeaponRequest.getProfession()).build()).build();
    }

}
