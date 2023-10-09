package cc.robotdreams.kanboard.api;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonParsing
{
    public static Object jsonParsing(String json, String key){
        String value = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(json);

            value = jsonNode.get(key).asText();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;

    }
}

