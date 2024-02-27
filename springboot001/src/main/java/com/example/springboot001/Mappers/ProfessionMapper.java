package com.example.springboot001.Mappers;
import com.example.springboot001.DTO.Actualizations.GetProfessionResponse;
import com.example.springboot001.DTO.Actualizations.PutProfessionRequest;
import com.example.springboot001.DTO.ProfessionDTO;
import com.example.springboot001.Entities.Profession;
import org.mapstruct.Mapper;


@Mapper
public interface ProfessionMapper {
    //Profession professionDtotoProfession(ProfessionDTO professionDTO);
    ProfessionDTO professiontoProfessionDto(Profession profession);

    GetProfessionResponse professionToGetProfessionResponse(Profession profession);

    Profession putProfessionRequesttoProfession(PutProfessionRequest putProfessionRequest);
}
