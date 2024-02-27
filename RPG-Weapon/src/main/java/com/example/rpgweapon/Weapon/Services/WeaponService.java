package com.example.rpgweapon.Weapon.Services;


import com.example.rpgweapon.Weapon.Entities.Weapon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface WeaponService {
    void saveNewWeapon(Weapon weapon);
    List<Weapon> findAllWeapons();
    List<Weapon> findByProfessionName(String professionName);

    Optional<Weapon> findByName(String weaponName);


    void deleteWeaponById(UUID uuid);
}
