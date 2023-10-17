package com.example.one16challenge.model;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class FileReader {

    //Load a set of unique words from the list
    public static Set<String> loadWordList(String filePath) throws IOException {

        //Hashset to filter out duplicates and for time complexity purpose
        Set<String> words = new HashSet<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            for (String line : lines) {
                if (!line.isEmpty()) {
                    words.add(line);
                }
            }

        } catch (IOException e) {
            //TODO: add different logging
            e.printStackTrace();
        }
        return words;
    }

}
