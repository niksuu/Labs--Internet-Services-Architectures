package com.example.rpgprofession.Profession.Repository;


import com.example.rpgprofession.Profession.Entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession,UUID>{
        Optional<Profession> findByName(String name);

}
