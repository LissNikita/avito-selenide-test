package org.avito.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.avito.models.CarData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    @DataProvider(name = "carNameData")
    public Object[][] getCarNameData() throws IOException {
        String filePath = "src/test/resources/test-data/carNameData.json";
        List<CarData> carDataList = readTestCarNameDataFromJson(filePath);

        Object[][] data = new Object[carDataList.size()][1];
        for (int i = 0; i < carDataList.size(); i++) {
            data[i][0] = carDataList.get(i);
        }

        return data;
    }

    private List<CarData> readTestCarNameDataFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            return objectMapper.readValue(fis, new TypeReference<List<CarData>>() {
            });
        }
    }
}
