package com.example.springboot001.DTO.Actualizations;

import com.example.springboot001.DTO.WeaponDTO;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetWeaponsResponse {
    @Singular
    private List<WeaponDTO> weapons;
}
