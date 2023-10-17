package com.example.one16challenge.model;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class WordValidator {

    //validate and combine the words to their combination
    public static Set<String> validateCombinations(Set<String> requiredLengthWords, Set<String> possibleWordCombinations) {
        Set<String> validCombinations = new HashSet<>();

        //iterate over the possible words comabinations
        for (String possibleWordCombination : possibleWordCombinations) {
            //split up the word in the asked format to be able to match the combined word
            String[] parts = possibleWordCombination.split("[+=]");
            //take the last part to include future multiple word combinations
            String combinedWord = parts[parts.length - 1];

            //check if word is present in the list
            if (requiredLengthWords.contains(combinedWord)) {
                validCombinations.add(possibleWordCombination);
            }
        }

        return validCombinations;
    }

}
