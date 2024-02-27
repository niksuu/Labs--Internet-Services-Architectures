package com.example.springboot001.Repositories;

import com.example.springboot001.Entities.Profession;
import com.example.springboot001.Entities.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProfessionRepository extends JpaRepository<Profession,UUID>{
        Profession findByName(String name);
}
