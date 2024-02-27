package com.example.rpgprofession.Profession.Controller;



import com.example.rpgprofession.Profession.Dto.GetProfessionResponse;
import com.example.rpgprofession.Profession.Dto.GetProffessionsResponse;
import com.example.rpgprofession.Profession.Dto.PutProfessionRequest;
import com.example.rpgprofession.Profession.Mappers.ProfessionMapper;
import com.example.rpgprofession.Profession.Service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/professions")
@RequiredArgsConstructor
public class ProfessionController {


    private final ProfessionService professionService;
    private final ProfessionMapper professionMapper;


    @GetMapping
    public ResponseEntity<GetProffessionsResponse> getProfessions()
    {
        return ResponseEntity.ok(GetProffessionsResponse.builder().professions(professionService.findAllProfessions().stream().map(professionMapper::professiontoProfessionDto).collect(Collectors.toList())).build());
    }

    @GetMapping("/{professionId}")
    public ResponseEntity<GetProfessionResponse> GetProfession(@PathVariable("professionId") UUID professionId)
    {
        return ResponseEntity.ok(professionService.findProfessionById(professionId).map(professionMapper::professionToGetProfessionResponse).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @PutMapping("/{professionId}")
    public ResponseEntity<Void> putProfession(@PathVariable("professionId") UUID professionId, @RequestBody PutProfessionRequest request)
    {
        professionService.UpdateProfessionId(professionId,professionMapper.putProfessionRequesttoProfession(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{professionId}")
    public ResponseEntity<Void> deleteProfession(@PathVariable("professionId") UUID Professionid)
    {
        professionService.DeleteProfessionById(Professionid);
        return ResponseEntity.ok().build();
    }


}
