package com.example.rpgweapon.Profession.Services;



import com.example.rpgweapon.Profession.Entities.Profession;
import com.example.rpgweapon.Profession.Repositories.ProfessionRepository;
import com.example.rpgweapon.Weapon.Entities.Weapon;
import com.example.rpgweapon.Weapon.Repositories.WeaponRepository;
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

    private final WeaponRepository weaponRepository;


    @Override
    public List<Profession> findAllProfessions()
    {
        return professionRepository.findAll();
    }


    public void saveNewProfession(Profession profession)
    {
         professionRepository.save(profession);
    }

    @Override
    public Optional<Profession> findProfessionById(UUID uuid){return professionRepository.findById(uuid);}



    @Override
    public void DeleteProfessionById(UUID uuid)
    {
        Optional <Profession > profession =professionRepository.findById(uuid);
        List<Weapon> weapons = weaponRepository.findByProfessionName(profession.orElseThrow().getName());
        for(Weapon weapon:weapons)
        {
            weaponRepository.deleteById(weapon.getId());
        }
        professionRepository.deleteById(uuid);
    }



}
