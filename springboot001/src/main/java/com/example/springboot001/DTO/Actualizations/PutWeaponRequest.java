package com.example.springboot001.DTO.Actualizations;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PutWeaponRequest {
    private String name;
    private int damage;
    private UUID profession;
}
