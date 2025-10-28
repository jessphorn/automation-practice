package utilties;

import java.io.IOException;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.File;

public class JSONReader {

    public static JsonNode readJsonFile (String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(new File(path));
    }
    
    public static String getLocatedBy (JsonNode jsonData, String elementName) {
        return jsonData.get(elementName).get("by").asString();
    }
    
    public static String getLocator (JsonNode jsonData, String elementName, String locatedBy) {
      return jsonData.get(elementName).get(locatedBy).asString();
    }
    
    public static String getTestData(String path, String key) throws IOException {
        JsonNode testData = new ObjectMapper().readTree(new File(path));
        return testData.get(key).asString();
    }
 }
