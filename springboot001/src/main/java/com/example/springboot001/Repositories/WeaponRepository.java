package com.example.springboot001.Repositories;


import com.example.springboot001.Entities.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, UUID> {
    List<Weapon> findByProfessionName(String professionName);
    Weapon findByName(String weaponName);
}
