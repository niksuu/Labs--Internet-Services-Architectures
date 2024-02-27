package com.example.springboot001.DTO.Actualizations;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(exclude = "name")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class GetWeaponResponse {
    private UUID id;
    private String name;
    private int damage;
}
