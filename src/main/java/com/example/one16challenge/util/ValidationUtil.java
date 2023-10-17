package com.example.one16challenge.util;

import java.io.File;

public class ValidationUtil {

    public static void checkValidWordLength(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Invalid word length. Length must be a positive integer.");
        }
    }

    public static void checkValidMaxLength(int maxLength) {
        if (maxLength <= 0) {
            throw new IllegalArgumentException("Invalid max word length. Max length must be a positive integer.");
        }
    }

    public static void checkValidFilePath(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("Invalid file path. Please provide a valid file path.");
        }

        File file = new File(filePath);

        if (!file.exists()) {
            throw new IllegalArgumentException("File does not exist: " + filePath);
        }

        if (!file.isFile()) {
            throw new IllegalArgumentException("Not a valid file: " + filePath);
        }

        if (!filePath.toLowerCase().endsWith(".txt")) {
            throw new IllegalArgumentException("Invalid file format. Only '.txt' files are allowed.");
        }
    }

}
