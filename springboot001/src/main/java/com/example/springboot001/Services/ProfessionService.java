package com.example.springboot001.Services;

import com.example.springboot001.Entities.Profession;
import com.example.springboot001.Entities.Weapon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessionService {
    Profession saveNewProfession(Profession profession);
    List<Profession> findAllProfessions();

    Profession findByName(String professionName);

}
