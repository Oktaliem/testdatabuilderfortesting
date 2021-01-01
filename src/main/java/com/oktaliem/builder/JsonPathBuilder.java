package com.oktaliem.builder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.oktaliem.constants.ConstantForPath.MAIN_RESOURCES_PATH;

public class JsonPathBuilder {

    String filename;

    public JsonPathBuilder(String filename) {
        this.filename = filename;
    }

    public String getJsonFile() throws IOException {
        String json = MAIN_RESOURCES_PATH + filename;
        return Files.readString(Paths.get(json));
    }

}