package com.oktaliem.unittest;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.oktaliem.builder.EncryptionBuilder;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EncryptionBuilderTest {

    EncryptionBuilder encryption = new EncryptionBuilder();
    public static final String base64result = "ewogICJsYXN0TmFtZSIgOiAiSm9lIiwKICAiZmlyc3Ru" +
            "YW1lIiA6ICJPa3RhIiwKICAibGFzdG5hbWUiIDogIkpvZSIsCiAgImVtYWlsIiA6ICJhY" +
            "mNAZ21haWwuY29tIiwKICAiZGF0ZSIgOiAiMDEvMDEvMTk2NyIsCiAgImFkZHJlc3MiIDo" +
            "gIlNpbmdhcG9yZSIsCiAgImNjIiA6IHsKICAgICJudW1iZXIiIDogIjQ0NDQtNDQ0NC00NDQ0" +
            "LTU1NTUiLAogICAgImJhbmsiIDogIkJDQSIKICB9LAogICJwcm9kdWN0IiA6IHsKICAgIC" +
            "J0eXBlIiA6ICJHb2xkIgogIH0KfQ==";


    @Test
    public void encodeStringToBase64String() {
        String testData = "{\n" +
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

        String result = encryption.base64Encoder(testData);
        System.out.println(result);
        Assert.assertEquals(base64result, result);
    }

    @Test
    public void decodeBase64ToString() {
        String result = encryption.base64Decoder(base64result);
        System.out.println(result);
        String expected = "{\n" +
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
        Assert.assertEquals(expected, result);
    }

    @Test
    public void convertToSha256() {
        String url = "https://www.google.com/";
        String result = encryption.convertToSha256(url);
        System.out.println(result);
        Assert.assertEquals("d0e196a0c25d35dd0a84593cbae0f38333aa58529936444ea26453eab28dfc86", result);
    }

    @Test
    public void convertToSha512() throws NoSuchAlgorithmException {
        String url = "https://www.google.com/";
        String result = encryption.convertToSha512(url);
        System.out.println(result);
        String guava = encryption.convertToSha512WithGuava(url);
        System.out.println(guava);
        Assert.assertEquals(result, guava);
    }

    @Test
    public void convertToSha1() throws NoSuchAlgorithmException {
        String url = "https://www.google.com/";
        String result = encryption.convertToSha1WithGuava(url);
        System.out.println(result);
        Assert.assertEquals("595c3cce2409a55c13076f1bac5edee529fc2e58", result);
    }

    @Test
    public void convertToHmacSha256() throws NoSuchAlgorithmException {
        String value = "98655433344678";
        byte[] secretKey = "345667".getBytes();
        String result = encryption.convertToHmacSha256WithGuava(value, secretKey);
        System.out.println(result);
        String result2 = encryption.convertToHmacSha256WithGuavaWithApache(value, secretKey);
        System.out.println(result2);
        Assert.assertEquals(result2, result);
    }

    @Test
    public void generateRandomOTP() {
        int digit = 4;
        String result = encryption.generateRandomOTP(digit);
        System.out.println(result);
    }

    @Test
    public void convertToMd5() {
        String url = "https://www.google.com/";
        String result = encryption.convertToMd5WithGuava(url);
        System.out.println(result);
        Assert.assertEquals("d75277cdffef995a46ae59bdaef1db86", result);
    }

    @Test
    public void encodeURL() throws UnsupportedEncodingException {
        String url = "https://www.google.com/search?q=";
        String query = "Learn Java Code 101 +-";
        String result = encryption.encodeUrl(url, query);
        System.out.println(result);
        Assert.assertEquals("https://www.google.com/search?q=Learn+Java+Code+101+%2B-", result);
    }

    @Test
    public void decodeURL() throws UnsupportedEncodingException {
        String url = "https://www.google.com/search?q=Learn+Java+Code+101+%2B-";
        String result = encryption.decode(url);
        System.out.println(result);
        Assert.assertEquals("https://www.google.com/search?q=Learn Java Code 101 +-", result);
    }

    @Test
    public void generateQrCode() throws IOException, WriterException {
        String name = "okta_SDET_Anywhere";
        String path = System.getProperty("user.dir") + "/src/main/resources/result.jpg";
        encryption.generateQrCode(name, path);
    }

    @Test
    public void readQrCode() throws IOException, WriterException, NotFoundException {
        String name = "okta_SDET_Anywhere";
        String path = System.getProperty("user.dir") + "/src/main/resources/qrCode.jpg";
        String result = encryption.readQrCode(path);
        System.out.println(result);
        Assert.assertEquals(name,result);
    }

}
