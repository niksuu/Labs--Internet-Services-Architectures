package com.example.rpgprofession.Profession.Dto;

import com.example.rpgprofession.Profession.Dto.model.ProfessionDTO;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetProffessionsResponse {
    private List<ProfessionDTO> professions;
}
