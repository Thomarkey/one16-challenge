package com.example.one16challenge.model;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class WordValidator {

    //Validate combinations and return a set of valid combinations
    public static Set<String> validateCombinations(Set<String> possibleSolutionList, Set<String> possibleWordCombinationsList) {
        Set<String> validCombinations = new HashSet<>();

        for (String solution : possibleSolutionList) {
            if (possibleWordCombinationsList.contains(solution)) {
                validCombinations.add(solution);
            }
        }

        return validCombinations;
    }

}
