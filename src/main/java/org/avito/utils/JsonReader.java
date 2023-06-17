package org.avito.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.avito.models.CarNameData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    @DataProvider(name = "carNameData")
    public Object[][] getCarNameData() throws IOException {
        String filePath = "src/test/resources/test-data/carNameData.json";
        List<CarNameData> carNameDataList = readTestCarNameDataFromJson(filePath);

        Object[][] data = new Object[carNameDataList.size()][1];
        for (int i = 0; i < carNameDataList.size(); i++) {
            data[i][0] = carNameDataList.get(i);
        }

        return data;
    }

    private List<CarNameData> readTestCarNameDataFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            return objectMapper.readValue(fis, new TypeReference<List<CarNameData>>() {
            });
        }
    }
}
