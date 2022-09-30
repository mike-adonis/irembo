package com.example.irembo.controller;

public class Helper {

    public static <T> void populateMapWithAllAlphabets(MapInitializer initializer) {
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            initializer.add(ch);
        }
    }

}
