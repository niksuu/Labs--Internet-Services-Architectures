package com.example.springboot001.DTO;

import lombok.*;
import java.util.*;
import jakarta.persistence.Entity;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class ProfessionDTO {
    private UUID id;
    private String name;
    private int baseArmor;
}


