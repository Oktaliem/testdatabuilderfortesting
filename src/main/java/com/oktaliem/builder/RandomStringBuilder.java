package com.oktaliem.builder;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.UUID;

public class RandomStringBuilder {

    public String generateRandomUUID(){
        return UUID.randomUUID().toString();
    }

    public String generateRandomUUUIDWithoutDash(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public String generateRandomAlphanumeric(int digits){
        String NUM = "1234567890";
        String CHAR_UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String CHAR_LOWER_CASE = CHAR_UPPER_CASE.toLowerCase(Locale.ROOT);
        String characters = NUM + CHAR_LOWER_CASE + CHAR_UPPER_CASE;
        SecureRandom random = new SecureRandom();
        StringBuilder builder = new StringBuilder(digits);
        for (int i = 0; i < digits; i++) {
            int lengthOfChar = random.nextInt(characters.length());
            char randomChar = characters.charAt(lengthOfChar);
            builder.append(randomChar);
        }
        return builder.toString();
    }

    public String generateStrengthPassword(int digits){
        String NUM = "1234567890";
        String CHAR_UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String CHAR_LOWER_CASE = CHAR_UPPER_CASE.toLowerCase(Locale.ROOT);
        String SPECIAL_CHARS = "~!@#$%^&*()_+`-={}|[]:':<>?<>/";
        String characters = NUM + CHAR_LOWER_CASE + CHAR_UPPER_CASE + SPECIAL_CHARS;
        SecureRandom random = new SecureRandom();
        StringBuilder builder = new StringBuilder(digits);
        for (int i = 0; i < digits; i++) {
            int lengthOfChar = random.nextInt(characters.length());
            char randomChar = characters.charAt(lengthOfChar);
            builder.append(randomChar);
        }
        return builder.toString();
    }
}
