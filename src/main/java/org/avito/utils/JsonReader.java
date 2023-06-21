package org.avito.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.avito.models.CarData;
import org.avito.models.UserData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    @DataProvider(name = "carData")
    public Object[][] getCarData() throws IOException {
        String filePath = "src/test/resources/test-data/carData.json";
        List<CarData> carDataList = readTestCarNameFromJson(filePath);

        Object[][] data = new Object[carDataList.size()][1];
        for (int i = 0; i < carDataList.size(); i++) {
            data[i][0] = carDataList.get(i);
        }

        return data;
    }

    private List<CarData> readTestCarNameFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            return objectMapper.readValue(fis, new TypeReference<List<CarData>>() {
            });
        }
    }

    @DataProvider(name = "userData")
    public Object[][] getUserData() throws IOException {
        String filePath = "src/test/resources/test-data/userData.json";
        List<UserData> userDataList = readTestUserDataFromJson(filePath);

        Object[][] data = new Object[userDataList.size()][1];
        for (int i = 0; i < userDataList.size(); i++) {
            data[i][0] = userDataList.get(i);
        }

        return data;
    }

    private List<UserData> readTestUserDataFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            return objectMapper.readValue(fis, new TypeReference<List<UserData>>() {
            });
        }
    }
}
