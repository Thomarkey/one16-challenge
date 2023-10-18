package com.example.one16challenge.model;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FileHelper {

    //Create the set of words with specific length
    public static Set<String> filterWordsByLength(Set<String> wordList, int maxLength) {
        return wordList.stream()
                .filter(word -> word.length() == maxLength)
                .collect(Collectors.toSet());
    }

    //Remove words that are of a given length or longer since they cant combine to exact this length
    public static Set<String> reduceWordsToMaxWordLength(Set<String> wordList, int length) {
        wordList.removeIf(word -> word.length() >= length);
        return wordList;
    }

}
