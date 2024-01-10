package com.trading.config.converter;

import com.trading.common.constants.YesNo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class YesNoConverter implements AttributeConverter<YesNo, String> {

    @Override
    public String convertToDatabaseColumn(YesNo attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public YesNo convertToEntityAttribute(String dbData) {
        for (YesNo enumValue : YesNo.values()) {
            if (enumValue.getCode().equals(dbData)) {
                return enumValue;
            }
        }
        throw new IllegalArgumentException("Unknown database value: " + dbData);
    }
}
