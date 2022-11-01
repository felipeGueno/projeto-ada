package com.apimanifestacaosac.enums.converter;

import com.apimanifestacaosac.enums.Canal;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EnumCanalConverter implements AttributeConverter<Canal, String> {
    @Override
    public String convertToDatabaseColumn(Canal canal) {
        return canal.name();
    }

    @Override
    public Canal convertToEntityAttribute(String s) {
        return Canal.valueOf(s);
    }
}
