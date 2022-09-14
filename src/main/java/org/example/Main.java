package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        JsonComparator jc = new JsonComparator();
        File leftJson = Paths.get("input1.json").toFile();
        File rightJson = Paths.get("input2.json").toFile();
        try {
            jc.compare(leftJson, rightJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}