package com.example.rpgweapon.Weapon.Controller;

import com.example.rpgweapon.Profession.Entities.Profession;
import com.example.rpgweapon.Profession.Services.ProfessionService;
import com.example.rpgweapon.Weapon.DTO.PutWeaponRequest;

import com.example.rpgweapon.Weapon.DTO.GetWeaponResponse;
import com.example.rpgweapon.Weapon.DTO.GetWeaponsResponse;
import com.example.rpgweapon.Weapon.Mappers.WeaponMapper;
import com.example.rpgweapon.Weapon.Services.WeaponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private final WeaponMapper weaponMapper;

    @GetMapping
    public ResponseEntity<GetWeaponsResponse> getWeapons()
    {
        return ResponseEntity.ok(GetWeaponsResponse.builder().weapons(weaponService.findAllWeapons().stream().map(weaponMapper::WeaponToWeaponDto).toList()).build());
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
    public ResponseEntity<PutWeaponRequest> putWeaponByCustomerName(@PathVariable("weaponId") UUID uuid, @RequestBody PutWeaponRequest request)
    {
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
