package com.example.rpgweapon.Weapon.Services;


import com.example.rpgweapon.Weapon.Entities.Weapon;
import com.example.rpgweapon.Weapon.Repositories.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WeaponServiceJPA implements WeaponService{

    private final WeaponRepository weaponRepository;

    @Override
    public void saveNewWeapon(Weapon weapon)
    {
        weaponRepository.save(weapon);
    }

    @Override
    public List<Weapon> findAllWeapons()
    {
        return weaponRepository.findAll();
    }

    @Override
    public List<Weapon> findByProfessionName(String professionName) {
        return weaponRepository.findByProfessionName(professionName);
    }

    @Override
    public void deleteWeaponById(UUID uuid)
    {
        weaponRepository.deleteById(uuid);
    }

    @Override
    public Optional<Weapon> findByName(String weaponName)
    {
        return weaponRepository.findByName(weaponName);
    }



}
