package com.codeclause.services;

import org.springframework.stereotype.Service;

@Service
public class UrlBaseHandler {
    private static final String possibleChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final char[] allowedCharacters = possibleChars.toCharArray();
    private int length = allowedCharacters.length;

    public String encode(long input){
        var encodedString = new StringBuilder();

        if(input == 0) {
            return String.valueOf(allowedCharacters[0]);
        }

        while (input > 0) {
            encodedString.append(allowedCharacters[(int) (input % length)]);
            input = input / length;
        }

        return encodedString.reverse().toString();
    }

    public long decode(String input) {
        var characters = input.toCharArray();
        var length = characters.length;

        var decoded = 0;

        //counter is used to avoid reversing input string
        var counter = 1;
        for (int i = 0; i < length; i++) {
            decoded += possibleChars.indexOf(characters[i]) * Math.pow(length, length - counter);
            counter++;
        }
        return decoded;
    }

}
