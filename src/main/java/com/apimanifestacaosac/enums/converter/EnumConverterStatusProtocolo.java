package com.apimanifestacaosac.enums.converter;

import com.apimanifestacaosac.enums.StatusProtocolo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EnumConverterStatusProtocolo implements AttributeConverter<StatusProtocolo, String> {
    @Override
    public String convertToDatabaseColumn(StatusProtocolo statusProtocolo) {
        return statusProtocolo.name();
    }

    @Override
    public StatusProtocolo convertToEntityAttribute(String s) {
        return StatusProtocolo.valueOf(s);
    }
}
