package com.example.springboot001.Services;


import com.example.springboot001.Entities.Profession;
import com.example.springboot001.Entities.Weapon;
import com.example.springboot001.Repositories.ProfessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionServiceJPA implements ProfessionService{

    private final ProfessionRepository professionRepository;

    @Override
    public Profession saveNewProfession(Profession profession)
    {
        return professionRepository.save(profession);
    }

    @Override
    public List<Profession> findAllProfessions()
    {
        return professionRepository.findAll();
    }

    @Override
    public Profession findByName(String ProfessionName){return professionRepository.findByName(ProfessionName);}
}
