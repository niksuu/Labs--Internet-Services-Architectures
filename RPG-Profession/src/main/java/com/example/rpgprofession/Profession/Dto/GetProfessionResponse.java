package com.example.rpgprofession.Profession.Dto;

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
