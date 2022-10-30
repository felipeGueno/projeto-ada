package com.apimanifestacaosac.enums.converter;

import com.apimanifestacaosac.enums.Tipo_Telefone;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EnumTipo_TelefoneConverter implements AttributeConverter<Tipo_Telefone, String> {
    @Override
    public String convertToDatabaseColumn(Tipo_Telefone tipo_telefone) {
    return tipo_telefone.name();
    }

    @Override
    public Tipo_Telefone convertToEntityAttribute(String s) {
        return Tipo_Telefone.valueOf(s);
    }
}
