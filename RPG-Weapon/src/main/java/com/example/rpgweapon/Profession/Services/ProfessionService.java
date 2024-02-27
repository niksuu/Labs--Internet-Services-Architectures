package com.example.rpgweapon.Profession.Services;


import com.example.rpgweapon.Profession.Entities.Profession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ProfessionService {

    List<Profession> findAllProfessions();


    void  saveNewProfession(Profession profession);

    Optional<Profession> findProfessionById(UUID uuid);


    void DeleteProfessionById(UUID uuid);


}
