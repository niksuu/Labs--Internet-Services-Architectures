package com.example.rpgprofession.Profession.Service;



import com.example.rpgprofession.Profession.Entity.Profession;
import com.example.rpgprofession.Profession.Event.ProfessionEventRestRepository;
import com.example.rpgprofession.Profession.Repository.ProfessionRepository;
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

    private final ProfessionEventRestRepository professionEventRestRepository;

    //private final WeaponRepository weaponRepository;

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
        professionEventRestRepository.create(uuid);
    }

    @Override
    public void DeleteProfessionById(UUID uuid)
    {
        professionRepository.deleteById(uuid);
        professionEventRestRepository.delete(uuid);
    }



}
