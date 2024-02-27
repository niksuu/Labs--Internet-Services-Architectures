package com.example.rpgprofession.Profession.Event;

import com.example.rpgprofession.Profession.Entity.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class ProfessionEventRestRepository implements ProfessionEventRepository{

    private final RestTemplate restTemplate;

    @Autowired
    public ProfessionEventRestRepository(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }

    @Override
    public void delete(UUID uuid) {
        restTemplate.delete("/api/professions/{professionId}", uuid);
    }


    @Override
    public void create(UUID uuid) {
        Profession profession = Profession.builder().build();
        restTemplate.put("/api/professions/{professionId}",profession, uuid);
    }
}
