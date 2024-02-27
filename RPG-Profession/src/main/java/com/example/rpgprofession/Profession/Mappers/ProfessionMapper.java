package com.example.rpgprofession.Profession.Mappers;
import com.example.rpgprofession.Profession.Dto.GetProfessionResponse;
import com.example.rpgprofession.Profession.Dto.PutProfessionRequest;
import com.example.rpgprofession.Profession.Dto.model.ProfessionDTO;
import com.example.rpgprofession.Profession.Entity.Profession;
import org.mapstruct.Mapper;


@Mapper
public interface ProfessionMapper {
    //Profession professionDtotoProfession(ProfessionDTO professionDTO);
    ProfessionDTO professiontoProfessionDto(Profession profession);

    GetProfessionResponse professionToGetProfessionResponse(Profession profession);

    Profession putProfessionRequesttoProfession(PutProfessionRequest putProfessionRequest);
}
