package com.example.springboot001.Controllers;


import com.example.springboot001.DTO.Actualizations.GetWeaponResponse;
import com.example.springboot001.DTO.Actualizations.GetWeaponsResponse;
import com.example.springboot001.DTO.Actualizations.PutWeaponRequest;
import com.example.springboot001.Entities.Profession;
import com.example.springboot001.Mappers.WeaponMapper;
import com.example.springboot001.Services.ProfessionService;
import com.example.springboot001.Services.WeaponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/weapons")
@RequiredArgsConstructor
public class WeaponController {

    private final WeaponService weaponService;
    private final ProfessionService professionService;
    private final WeaponMapper weaponMapper;

    @GetMapping
    public ResponseEntity<GetWeaponsResponse> getWeapons()
    {
        return ResponseEntity.ok(GetWeaponsResponse.builder().weapons(weaponService.findAllWeapons().stream().map(weaponMapper::WeaponToWeaponDto).collect(Collectors.toList())).build());
    }

    @GetMapping("/{weaponName}")
    public ResponseEntity<GetWeaponResponse> getWeapon(@PathVariable("weaponName") String  WeaponName)
    {
        return ResponseEntity.ok(weaponService.findByName(WeaponName).map(weaponMapper::WeaponToGetWeaponResponse).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping("/{professionName}/weapons")
    public ResponseEntity<GetWeaponsResponse> getWeaponsOfProfession(@PathVariable("professionName") String ProfessionName){
        return ResponseEntity.ok(GetWeaponsResponse.builder().weapons(weaponService.findByProfessionName(ProfessionName).stream().map(weaponMapper::WeaponToWeaponDto).toList()).build());
    }

    @PutMapping("/{weaponId}")
    public ResponseEntity<PutWeaponRequest> putWeaponByCustomerName(@PathVariable("weaponId") UUID uuid,@RequestBody PutWeaponRequest request)
    {
        Optional<Profession> posibleprofession = professionService.findProfessionById(uuid);
        if(!posibleprofession.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        weaponService.saveNewWeapon(weaponMapper.putWeaponRequestToProfession(uuid,request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{weaponId}")
    public ResponseEntity<Void> deleteWeapon(@PathVariable("weaponId") UUID Weaponid)
    {
        weaponService.deleteWeaponById(Weaponid);
        return ResponseEntity.accepted().build();
    }

}
