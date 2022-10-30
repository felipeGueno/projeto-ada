package com.apimanifestacaosac.enums.converter;

import com.apimanifestacaosac.enums.Departamento;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EnumDepartamentoConverter implements AttributeConverter<Departamento, String> {

    @Override
    public String convertToDatabaseColumn(Departamento departamento) {
        return departamento.name();
    }

    @Override
    public Departamento convertToEntityAttribute(String s) {
        return Departamento.valueOf(s);
    }
}
