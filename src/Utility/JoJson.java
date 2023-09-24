package Utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JoJson {

    private JsonNode jsonNode;
    private HashMap<String, String> jsonModel;

    public JoJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonModel = new HashMap<>();
            String str = mapper.writeValueAsString(jsonModel);
            jsonNode = mapper.readTree(str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public JoJson(String jsonText) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonNode = mapper.readTree(jsonText);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public JoJson(HashMap<String, String> jsonModel) {
        this.jsonModel = jsonModel;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String str = mapper.writeValueAsString(jsonModel);
            jsonNode = mapper.readTree(str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void setValue(String key, String value) {
        jsonModel.put(key, value);
        UpdateNode();
    }

    private void UpdateNode() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String str = mapper.writeValueAsString(jsonModel);
            jsonNode = mapper.readTree(str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return jsonNode.size();
    }

    public Iterator<Map.Entry<String, JsonNode>> getJsonAll() {
        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = jsonNode.fields();
        return fieldsIterator;
    }

    public String getString(String key) {
        try {
            return jsonNode.get(key).asText();
        } catch (Exception e) {
            return null;
        }
    }

    public int getInt(String key) {
        try {
            return jsonNode.get(key).asInt();
        } catch (Exception e) {
            return 0;
        }
    }

    public String getJsonString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String str = mapper.writeValueAsString(jsonModel);
            return str;
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public void clear() {
        jsonModel.clear();
    }

}
