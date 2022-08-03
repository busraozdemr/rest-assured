package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;

public class JsonUtil {

    private JsonUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> T getJsonResponseFromFile(String filePath) throws FileNotFoundException {
        final JsonElement jsonElement = JsonParser.parseReader(new BufferedReader(
                new FileReader(System.getProperty("user.dir") + "/src/test/resources/json/response" + filePath)));
        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(jsonElement);
            return (T) jsonArray;
        }
        return (T) jsonElement;
    }

    public static JsonNode getJsonRequestFromFile(String filepath) throws IOException {
        return new ObjectMapper().readTree(
                new File(System.getProperty("user.dir") + "/src/test/resources/json/request" + filepath));
    }

    public static String getJsonSchemaPath(String schemaFileName) {
        return "json/response" + schemaFileName;
    }
}
