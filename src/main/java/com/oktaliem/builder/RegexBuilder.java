package com.oktaliem.builder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBuilder {

    public String getTestDataViaRegex(String text, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        String result = null;
        if (m.find()) {
            result = m.group(0).trim();
        }
        return result;
    }
}
