package com.example.one16challenge.model;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class WordCombiner {

    //Generate possible combinations of words with a specific length
    public static HashSet<String> generatePossibleCombinations(Set<String> wordList, int wordLength) {

        HashSet<String> combinations = new HashSet<>();

        //Loop trough each word and check combinations
        for (String word1 : wordList) {
            for (String word2 : wordList) {

                //Make sure we are not using the same word and if length is correct
                if (!(word1.equals(word2)) && (word1.length() + word2.length() == wordLength)) {
                    //Add both combinations in asked format
                    String combination1 = word1 + "+" + word2 + "=" + word1 + word2;
                    String combination2 = word2 + "+" + word1 + "=" + word2 + word1;
                    combinations.add(combination1);
                    combinations.add(combination2);
                }
            }
        }

        return combinations;
    }
}
