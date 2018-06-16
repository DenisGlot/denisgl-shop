package com.denisgl.util;

public class NumberUtils {

    public static int parseStringToInt(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
