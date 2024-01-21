package com.trading.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class JsonFileWriter {
    public static void writeJsonFile(Object data, String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonData = objectMapper.writeValueAsString(data);

            File file = new File(filePath);
            FileUtils.writeStringToFile(file, jsonData, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
