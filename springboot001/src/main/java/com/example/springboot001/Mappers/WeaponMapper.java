package com.example.springboot001.Mappers;

import com.example.springboot001.DTO.Actualizations.GetWeaponResponse;
import com.example.springboot001.DTO.Actualizations.PutWeaponRequest;
import com.example.springboot001.DTO.WeaponDTO;
import com.example.springboot001.Entities.Profession;
import com.example.springboot001.Entities.Weapon;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper
public interface WeaponMapper {
    Weapon WeaponDtoToWeapon(WeaponDTO weaponDTO);

    WeaponDTO WeaponToWeaponDto(Weapon weapon);

    GetWeaponResponse WeaponToGetWeaponResponse(Weapon weapon);

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
