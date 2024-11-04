package com.aurora.utils;

public class StringUtils {

    public static String addLeadingZeros(String number) {
        int length = number.length();
        int zerosToAdd = Math.max(0, 5 - length); // Calcula la cantidad de ceros a añadir
        return String.format("%0" + (length + zerosToAdd) + "d", Integer.parseInt(number));
    }
}
