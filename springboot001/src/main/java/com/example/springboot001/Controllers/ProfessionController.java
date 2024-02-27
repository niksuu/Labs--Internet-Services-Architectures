package com.example.springboot001.Controllers;


import com.example.springboot001.DTO.Actualizations.GetProfessionResponse;
import com.example.springboot001.DTO.Actualizations.GetProffessionsResponse;
import com.example.springboot001.DTO.Actualizations.PutProfessionRequest;
import com.example.springboot001.DTO.ProfessionDTO;
import com.example.springboot001.Entities.Profession;
import com.example.springboot001.Mappers.ProfessionMapper;
import com.example.springboot001.Services.ProfessionService;
import com.example.springboot001.Services.ProfessionServiceJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
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
    public ResponseEntity<GetProfessionResponse> GetProfession(@PathVariable("professionId") UUID Professionid)
    {
        return ResponseEntity.ok(professionService.findProfessionById(Professionid).map(professionMapper::professionToGetProfessionResponse).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @PutMapping("/{professionId}")
    public ResponseEntity<Void> putProfession(@PathVariable("professionId") UUID Professionid, @RequestBody PutProfessionRequest request)
    {
        professionService.UpdateProfessionId(Professionid,professionMapper.putProfessionRequesttoProfession(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{professionId}")
    public ResponseEntity<Void> deleteProfession(@PathVariable("professionId") UUID Professionid)
    {
        professionService.DeleteProfessionById(Professionid);
        return ResponseEntity.ok().build();
    }


}
