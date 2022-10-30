package com.apimanifestacaosac.enums.converter;



import com.apimanifestacaosac.enums.Cargo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EnumCargoConverter  implements AttributeConverter<Cargo, String> {

    @Override
    public String convertToDatabaseColumn(Cargo cargo) {
    return cargo.name();
    }

    @Override
    public Cargo convertToEntityAttribute(String s) {
        return Cargo.valueOf(s);
    }
}
