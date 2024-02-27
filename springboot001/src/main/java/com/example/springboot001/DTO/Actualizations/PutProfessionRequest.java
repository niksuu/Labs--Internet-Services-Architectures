package com.example.springboot001.DTO.Actualizations;

import jakarta.persistence.Entity;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutProfessionRequest {
    private String name;
    private int baseArmor;
}
