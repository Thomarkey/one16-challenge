package com.example.one16challenge.model;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FileReader {

    //Load a set of unique words from the list
    public static Set<String> loadWordList(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines
                    .filter(line -> !line.isEmpty())
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
