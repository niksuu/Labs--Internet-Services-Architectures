package com.example.rpgweapon.Profession.Repositories;


import com.example.rpgweapon.Profession.Entities.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession,UUID>{

}
