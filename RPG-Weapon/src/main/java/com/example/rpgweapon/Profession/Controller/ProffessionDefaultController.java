package com.example.rpgweapon.Profession.Controller;


import com.example.rpgweapon.Profession.Entities.Profession;
import com.example.rpgweapon.Profession.Services.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProffessionDefaultController {
    private final ProfessionService professionService;
    @DeleteMapping("/api/professions/{professionId}")
    public ResponseEntity<Void> deleteProfession(@PathVariable("professionId")UUID uuid){
        professionService.DeleteProfessionById(uuid);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/api/professions/{professionId}")
    public ResponseEntity<Void> putProfession(@PathVariable("professionId") UUID uuid){
        Profession profession = Profession.builder().id(uuid).build();
        professionService.saveNewProfession(profession);
        return ResponseEntity.accepted().build();
    }
}
