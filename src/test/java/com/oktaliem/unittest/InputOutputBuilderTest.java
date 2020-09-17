package com.oktaliem.unittest;

import com.oktaliem.builder.InputAndOutputBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InputOutputBuilderTest {

    @Test
    public void getListOfFolders() {
        InputAndOutputBuilder io = new InputAndOutputBuilder();
        List<File> files = io.getAllFolderNameListed(System.getProperty("user.dir"));
        Assert.assertEquals("config", files.get(0).getName().trim());
        Assert.assertEquals("6094ab00eaf37105a3521532e616edc8dbf665", files.get(20).getName().trim());
    }

    @Test
    public void createJsonFileExist() throws IOException {
        String json = "{\n" +
                "  \"lastName\" : \"Joe\",\n" +
                "  \"firstname\" : \"Okta\",\n" +
                "  \"lastname\" : \"Joe\",\n" +
                "  \"email\" : \"abc@gmail.com\",\n" +
                "  \"date\" : \"01/01/1967\",\n" +
                "  \"address\" : \"Singapore\",\n" +
                "  \"cc\" : {\n" +
                "    \"number\" : \"4444-4444-4444-5555\",\n" +
                "    \"bank\" : \"BCA\"\n" +
                "  },\n" +
                "  \"product\" : {\n" +
                "    \"type\" : \"Gold\"\n" +
                "  }\n" +
                "}";
        String filename = System.getProperty("user.dir") + "/target/writeJson.json";
        FileWriter jsonFile = new FileWriter(filename);
        jsonFile.write(json);
        jsonFile.flush();
        jsonFile.close();

        File tempFile = new File(filename);
        boolean exists = tempFile.exists();
        Assert.assertTrue(exists);

    }

    @Test
    public void copyFileToGivenPath() throws IOException {
        File fileToCopy = new File("./src/main/resources/scratch.txt");
        File newFile = new File("./target/scratchCopied.txt");
        FileUtils.copyFile(fileToCopy, newFile);
        File tempFile = new File(String.valueOf(newFile));
        boolean exists = tempFile.exists();
        Assert.assertTrue(exists);
    }

}
