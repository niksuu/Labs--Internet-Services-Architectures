package com.example.springboot001.DTO.Actualizations;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetProfessionResponse {
    private UUID id;
    private String name;
    private int baseArmor;
}
