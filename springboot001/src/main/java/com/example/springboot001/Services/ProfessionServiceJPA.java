package com.example.springboot001.Services;


import com.example.springboot001.Entities.Profession;
import com.example.springboot001.Entities.Weapon;
import com.example.springboot001.Repositories.ProfessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
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
    public Optional<Profession> findByName(String ProfessionName){return professionRepository.findByName(ProfessionName);}


    @Override
    public Optional<Profession> findProfessionById(UUID uuid){return professionRepository.findById(uuid);}

    @Override
    public void UpdateProfessionId(UUID uuid, Profession profession)
    {
        profession.setId(uuid);
        professionRepository.save(profession);
    }

    @Override
    public void DeleteProfessionById(UUID uuid)
    {
        professionRepository.deleteById(uuid);
    }



}
