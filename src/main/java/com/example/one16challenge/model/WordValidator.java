package com.example.one16challenge.model;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class WordValidator {

    //Combine and validate the combined words
    public static Set<String> validateCombinations(Set<String> validWords, Set<String> possibleWordCombinations) {
        Set<String> validCombinations = new HashSet<>();

        //Iterate over the possible words combinations
        for (String possibleWordCombination : possibleWordCombinations) {
            //Split up the word in the asked format to be able to match the combined word
            String[] parts = possibleWordCombination.split("[+=]");
            //Take the last part to include future multiple word combinations
            String combinedWord = parts[parts.length - 1];

            //Check if word is present in the list
            if (validWords.contains(combinedWord)) {
                validCombinations.add(possibleWordCombination);
            }
        }

        return validCombinations;
    }

}
