package com.apimanifestacaosac;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Verificacao {

    public static List<String> verificaTodosCampoNulos(Object objeto) throws IllegalAccessException {

        Class<?> objetoClass = objeto.getClass();
        List<String> nomeCamposNulos = new ArrayList<>();

        Field[] fields = objetoClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object campo = field.get(objeto);
            if (campo == null) {
                nomeCamposNulos.add(field.getName());
            }
        }
        return nomeCamposNulos;
    }
}
