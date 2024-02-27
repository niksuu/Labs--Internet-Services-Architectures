package com.example.springboot001.DTO.Actualizations;

import com.example.springboot001.DTO.ProfessionDTO;
import com.example.springboot001.Entities.Profession;
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
