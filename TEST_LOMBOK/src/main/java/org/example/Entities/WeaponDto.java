package org.example.Entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Data
@EqualsAndHashCode(exclude = "name")
public class WeaponDto implements Serializable {
    @Setter
    @Getter
    String name;
    @Setter
    @Getter
    int damage;
    @Setter
    @Getter
    String profession;

    public WeaponDto(WeaponDtoBuilder WeaponDtoBuilder)
    {
        this.name=WeaponDtoBuilder.name;
        this.damage=WeaponDtoBuilder.damage;
        this.profession= WeaponDtoBuilder.profession;
    }


    public static class WeaponDtoBuilder{
        private String name;
        private int damage;
        private String profession;

        public WeaponDtoBuilder()
        {
        }


        public WeaponDtoBuilder profession(String profession)
        {
            this.profession=profession;
            return this;
        }
        public WeaponDtoBuilder name(String name)
        {
            this.name=name;
            return this;
        }

        public WeaponDtoBuilder damage(int damage)
        {
            this.damage=damage;
            return this;
        }



        public WeaponDto build()
        {
            return new WeaponDto(this);
        }


    }
}
