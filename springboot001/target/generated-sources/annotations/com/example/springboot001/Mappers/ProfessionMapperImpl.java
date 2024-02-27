package com.example.springboot001.Mappers;

import com.example.springboot001.DTO.Actualizations.GetProfessionResponse;
import com.example.springboot001.DTO.Actualizations.PutProfessionRequest;
import com.example.springboot001.DTO.ProfessionDTO;
import com.example.springboot001.Entities.Profession;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-07T11:07:14+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class ProfessionMapperImpl implements ProfessionMapper {

    @Override
    public ProfessionDTO professiontoProfessionDto(Profession profession) {
        if ( profession == null ) {
            return null;
        }

        ProfessionDTO.ProfessionDTOBuilder professionDTO = ProfessionDTO.builder();

        professionDTO.id( profession.getId() );
        professionDTO.name( profession.getName() );
        professionDTO.baseArmor( profession.getBaseArmor() );

        return professionDTO.build();
    }

    @Override
    public GetProfessionResponse professionToGetProfessionResponse(Profession profession) {
        if ( profession == null ) {
            return null;
        }

        GetProfessionResponse.GetProfessionResponseBuilder getProfessionResponse = GetProfessionResponse.builder();

        getProfessionResponse.id( profession.getId() );
        getProfessionResponse.name( profession.getName() );
        getProfessionResponse.baseArmor( profession.getBaseArmor() );

        return getProfessionResponse.build();
    }

    @Override
    public Profession putProfessionRequesttoProfession(PutProfessionRequest putProfessionRequest) {
        if ( putProfessionRequest == null ) {
            return null;
        }

        Profession.ProfessionBuilder profession = Profession.builder();

        profession.name( putProfessionRequest.getName() );
        profession.baseArmor( putProfessionRequest.getBaseArmor() );

        return profession.build();
    }
}
