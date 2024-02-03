package com.trading.config.converter;

import com.trading.domain.appversion.constants.AppType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AppTypeConverter implements AttributeConverter<AppType, String> {

    @Override
    public String convertToDatabaseColumn(AppType attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public AppType convertToEntityAttribute(String dbData) {
        for (AppType enumValue : AppType.values()) {
            if (enumValue.getCode().equals(dbData)) {
                return enumValue;
            }
        }
        throw new IllegalArgumentException("Unknown database value: " + dbData);
    }

}
