package com.oktaliem.unittest;

import com.oktaliem.builder.RegexBuilder;
import org.junit.Assert;
import org.junit.Test;

public class RegexTest {
    RegexBuilder regexBuilder = new RegexBuilder();

    @Test
    public void getTestDataWithRegex01() {
        String testData = "asdfasdfasd82353234227890sdfbbod";
        String pattern = "\\d\\d\\d([,\\s])?\\d\\d\\d\\d";
        String result = regexBuilder.getTestDataViaRegex(testData, pattern);
        System.out.println(result);
        Assert.assertEquals("8235323", result);
    }

    @Test
    public void getTestDataWithRegex02() {
        String testData = "The thing weighs 2.5 kilograms or so.";

        String pattern = "(\\w+)";
        String result = regexBuilder.getTestDataViaRegex(testData, pattern);
        System.out.println(result);
        Assert.assertEquals("The", result);

        String pattern2 = "(\\d+(\\.\\d+)?)";
        String result2 = regexBuilder.getTestDataViaRegex(testData, pattern2);
        System.out.println(result2);
        Assert.assertEquals("2.5", result2);
    }

    @Test
    public void getTestDataWithRegex03() {
        String testData = " <link type=\"image/x-icon\" rel=\"shortcut icon\" href=\"/web/static/src/img/favicon.ico\">\n" +
                "            <link type=\"text/css\" rel=\"stylesheet\" href=\"/web/content/422-63a0dae/web.assets_common.css\">\n" +
                "            <link type=\"text/css\" rel=\"stylesheet\" href=\"/web/content/423-7c1b46f/web.assets_frontend.css\">\n" +
                "        \n" +
                "\n" +
                "                <script type=\"text/javascript\">\n" +
                "                    var odoo = {\n" +
                "                        csrf_token: \"0d00be24b66cc67a314385d2fc023152cadf8452o\",\n" +
                "                        debug: \"\",\n" +
                "                    };\n" +
                "                </script>";
        String pattern = "csrf_token: \"\\w{41}\"";
        String result = regexBuilder.getTestDataViaRegex(testData, pattern);
        System.out.println(result);
        Assert.assertEquals("csrf_token: \"0d00be24b66cc67a314385d2fc023152cadf8452o\"", result);
    }

    @Test
    public void getEmailWithRegex() {
        String testData = "asdfasdfasd82353234227890sdfbbod [okta_234Okta@gmail.com} lbajser";
        String pattern = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        String result = regexBuilder.getTestDataViaRegex(testData, pattern);
        System.out.println(result);
        Assert.assertEquals("okta_234Okta@gmail.com", result);
    }

    @Test
    public void getIpWithRegex() {
        String testData = "asdfasdfas192.168.1.30sdfbbod [okta_234Okta@gmail.com} lbajser";
        String pattern = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        String result = regexBuilder.getTestDataViaRegex(testData, pattern);
        System.out.println(result);
        Assert.assertEquals("192.168.1.30", result);
    }

    @Test
    public void getPhoneNumberWithRegex() {
        String testData = "asdfasdfas1+625577647sdfbbod [okta_234Okta@gmail.com} lbajser";
        String pattern = "\\(?(?:\\+62|62|0)(?:\\d{2,3})?\\)?[ .-]?\\d{2,4}[ .-]?\\d{2,4}[ .-]?\\d{2,4}";
        String result = regexBuilder.getTestDataViaRegex(testData, pattern);
        System.out.println(result);
        Assert.assertEquals("+625577647", result);

        String testData2 = "asdfasdfas1+6593110169sdfbbod [okta_234Okta@gmail.com} lbajser";
        String pattern2 = "\\(?(?:\\+65|65|0)(?:\\d{2,3})?\\)?[ .-]?\\d{2,4}[ .-]?\\d{2,4}[ .-]?\\d{2,4}";
        String result2 = regexBuilder.getTestDataViaRegex(testData2, pattern2);
        System.out.println(result2);
        Assert.assertEquals("+6593110169", result2);
    }


    @Test
    public void getCreditCardWithRegex() {
        String testData = "card number 4121982229207001 visa card";
        String visa = "((?:(?:\\d{4}[- ]){3}\\d{4}|\\d{16}))(?![\\d])";
        String result = regexBuilder.getTestDataViaRegex(testData, visa);
        System.out.println(result);
        Assert.assertEquals("4121982229207001", result);

        String masterCardTestData = "master card data 5471944216625234 $$$";
        String masterCard = "((?:(?:\\d{4}[- ]){3}\\d{4}|\\d{16}))(?![\\d])";
        String result2 = regexBuilder.getTestDataViaRegex(masterCardTestData, masterCard);
        System.out.println(result2);
        Assert.assertEquals("5471944216625234", result2);

        String testDataDiscover = "ghlljlkj 6011466416728506 jskdfiiduid";
        String allCards = "^65[4-9][0-9]{13}|64[4-9][0-9]{13}|6011[0-9]{12}|(622(?:12[6-9]" +
                "|1[3-9][0-9]|[2-8][0-9][0-9]|9[01][0-9]|92[0-5])[0-9]{10})$";
        String result3 = regexBuilder.getTestDataViaRegex(testDataDiscover, allCards);
        System.out.println(result3);
        Assert.assertEquals("6011466416728506", result3);

    }
}