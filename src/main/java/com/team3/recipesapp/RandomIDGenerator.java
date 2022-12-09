package com.team3.recipesapp;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

public class RandomIDGenerator {
    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lower = upper.toLowerCase(Locale.ROOT);
    public static final String digits  = "1234567890";
    public static final String alphanum = upper + lower + digits;

    private final Random random;
    private char[] buffer;
    private final char[] symbols;

    public RandomIDGenerator(){
        this.random = new Random();
        this.symbols = alphanum.toCharArray();
    }

    public String generateRandomString(int length) {
        if(length < 1) throw new IllegalArgumentException();

        this.buffer = new char[length];

        for (int idx = 0; idx < buffer.length; ++idx)
            buffer[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buffer);
    }

    public String[] generateMultipleRandomStrings(int stringCount,int length){
        if(length < 1 || stringCount < 1) throw new IllegalArgumentException();
        this.buffer = new char[length];
        String[] stringArr = new String[stringCount];

        for (int i = 0; i < stringCount; i++) {

            for (int idx = 0; idx < buffer.length; ++idx)
                buffer[idx] = symbols[random.nextInt(symbols.length)];
            stringArr[i] = new String(buffer);
        }

        return stringArr;
    }


}
