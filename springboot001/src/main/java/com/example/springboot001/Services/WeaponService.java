package com.example.springboot001.Services;

import com.example.springboot001.Entities.Profession;
import com.example.springboot001.Entities.Weapon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface WeaponService {
    void saveNewWeapon(Weapon weapon);
    List<Weapon> findAllWeapons();
    List<Weapon> findByProfessionName(String professionName);

    Weapon findByName(String weaponName);
    void deleteWeaponById(UUID uuid);
}
