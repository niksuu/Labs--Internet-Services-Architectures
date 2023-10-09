package org.example.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Data
public class CharacterDto implements Serializable {
    String name;
    int level;
    String profession;

    public CharacterDto(CharacterDtoBuilder characterDtoBuilder)
    {
        this.name=characterDtoBuilder.name;
        this.level=characterDtoBuilder.level;
        this.profession= characterDtoBuilder.profession;
    }


    public static class CharacterDtoBuilder{
        private String name;
        private int level;
        private String profession;

        public CharacterDtoBuilder()
        {
        }


        public CharacterDtoBuilder profession(String profession)
        {
            this.profession=profession;
            return this;
        }
        public CharacterDtoBuilder name(String name)
        {
            this.name=name;
            return this;
        }

        public CharacterDtoBuilder level(int level)
        {
            this.level=level;
            return this;
        }



        public CharacterDto build()
        {
            return new CharacterDto(this);
        }


    }
}
