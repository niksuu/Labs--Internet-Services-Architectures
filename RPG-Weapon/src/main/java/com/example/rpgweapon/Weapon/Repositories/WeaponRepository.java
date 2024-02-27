package com.example.rpgweapon.Weapon.Repositories;



import com.example.rpgweapon.Weapon.Entities.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, UUID> {
    List<Weapon> findByProfessionName(String professionName);

    Optional<Weapon> findByName(String weaponName);
}
