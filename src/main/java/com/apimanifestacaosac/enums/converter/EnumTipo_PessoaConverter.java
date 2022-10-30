package com.apimanifestacaosac.enums.converter;


import com.apimanifestacaosac.enums.Tipo_Pessoa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EnumTipo_PessoaConverter implements AttributeConverter<Tipo_Pessoa, String> {
    @Override
    public String convertToDatabaseColumn(Tipo_Pessoa tipo_pessoa) {
        return tipo_pessoa.name();
    }

    @Override
    public Tipo_Pessoa convertToEntityAttribute(String s) {
        return Tipo_Pessoa.valueOf(s);
    }
}
