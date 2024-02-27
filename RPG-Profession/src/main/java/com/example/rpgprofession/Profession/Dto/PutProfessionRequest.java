package com.example.rpgprofession.Profession.Dto;

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
