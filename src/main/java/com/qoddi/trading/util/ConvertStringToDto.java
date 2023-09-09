package com.qoddi.trading.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConvertStringToDto {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> List<T> convertFromJson(String json, Class<T> dtoClass) {
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, dtoClass));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
