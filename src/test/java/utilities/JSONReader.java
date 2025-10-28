package utilities;

import java.io.IOException;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.File;

public class JSONReader {

    public static String getTestData(String path, String key) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File(path));
        return root.get(key).asString();       
    }
    
 }
