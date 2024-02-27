package com.example.springboot001.Mappers;

import com.example.springboot001.DTO.Actualizations.GetWeaponResponse;
import com.example.springboot001.DTO.ProfessionDTO;
import com.example.springboot001.DTO.WeaponDTO;
import com.example.springboot001.Entities.Profession;
import com.example.springboot001.Entities.Weapon;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-07T11:07:14+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class WeaponMapperImpl implements WeaponMapper {

    @Override
    public Weapon WeaponDtoToWeapon(WeaponDTO weaponDTO) {
        if ( weaponDTO == null ) {
            return null;
        }

        Weapon.WeaponBuilder weapon = Weapon.builder();

        weapon.id( weaponDTO.getId() );
        weapon.name( weaponDTO.getName() );
        weapon.damage( weaponDTO.getDamage() );
        weapon.profession( professionDTOToProfession( weaponDTO.getProfession() ) );

        return weapon.build();
    }

    @Override
    public WeaponDTO WeaponToWeaponDto(Weapon weapon) {
        if ( weapon == null ) {
            return null;
        }

        WeaponDTO.WeaponDTOBuilder weaponDTO = WeaponDTO.builder();

        weaponDTO.id( weapon.getId() );
        weaponDTO.name( weapon.getName() );
        weaponDTO.damage( weapon.getDamage() );
        weaponDTO.profession( professionToProfessionDTO( weapon.getProfession() ) );

        return weaponDTO.build();
    }

    @Override
    public GetWeaponResponse WeaponToGetWeaponResponse(Weapon weapon) {
        if ( weapon == null ) {
            return null;
        }

        GetWeaponResponse.GetWeaponResponseBuilder getWeaponResponse = GetWeaponResponse.builder();

        getWeaponResponse.id( weapon.getId() );
        getWeaponResponse.name( weapon.getName() );
        getWeaponResponse.damage( weapon.getDamage() );

        return getWeaponResponse.build();
    }

    protected Profession professionDTOToProfession(ProfessionDTO professionDTO) {
        if ( professionDTO == null ) {
            return null;
        }

        Profession.ProfessionBuilder profession = Profession.builder();

        profession.id( professionDTO.getId() );
        profession.name( professionDTO.getName() );
        profession.baseArmor( professionDTO.getBaseArmor() );

        return profession.build();
    }

    protected ProfessionDTO professionToProfessionDTO(Profession profession) {
        if ( profession == null ) {
            return null;
        }

        ProfessionDTO.ProfessionDTOBuilder professionDTO = ProfessionDTO.builder();

        professionDTO.id( profession.getId() );
        professionDTO.name( profession.getName() );
        professionDTO.baseArmor( profession.getBaseArmor() );

        return professionDTO.build();
    }
}
