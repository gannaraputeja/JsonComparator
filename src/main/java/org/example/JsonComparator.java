package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonDiff;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonComparator {

    public void compare(File leftJson, File rightJson) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode leftJsonNode = mapper.readTree(leftJson);
        JsonNode rightJsonNode = mapper.readTree(rightJson);

        JsonNode patch = JsonDiff.asJson(leftJsonNode, rightJsonNode);

        Map<String, JsonNode> result = new HashMap<>();
        patch.elements().forEachRemaining(element -> {
            result.put(element.findValue("path").asText(), element.findValue("value"));
        });

        result.forEach((key, value) ->{
            System.out.println(key + " : " + value);
        });

    }

}
