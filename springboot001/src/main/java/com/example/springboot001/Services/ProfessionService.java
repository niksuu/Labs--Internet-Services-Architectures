package com.example.springboot001.Services;

import com.example.springboot001.Entities.Profession;
import com.example.springboot001.Entities.Weapon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ProfessionService {
    Profession saveNewProfession(Profession profession);
    List<Profession> findAllProfessions();

    Optional<Profession> findByName(String professionName);

    Optional<Profession> findProfessionById(UUID uuid);

    void UpdateProfessionId(UUID uuid,Profession profession);

    void DeleteProfessionById(UUID uuid);


}
