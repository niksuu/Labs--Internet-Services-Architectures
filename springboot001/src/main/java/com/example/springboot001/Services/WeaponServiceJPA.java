package com.example.springboot001.Services;

import com.example.springboot001.Entities.Weapon;
import com.example.springboot001.Repositories.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Weapon findByName(String weaponName)
    {
        return weaponRepository.findByName(weaponName);
    }

}
