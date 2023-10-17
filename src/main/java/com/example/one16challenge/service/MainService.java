package com.example.one16challenge.service;

import com.example.one16challenge.model.FileHelper;
import com.example.one16challenge.model.FileReader;
import com.example.one16challenge.model.WordCombiner;
import com.example.one16challenge.model.WordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;


@Service
public class MainService {

    @Autowired
    private FileReader fileReader;
    @Autowired
    private FileHelper fileHelper;
    @Autowired
    private WordCombiner wordCombiner;
    @Autowired
    private WordValidator wordValidator;

    public Set<String> getSolution() throws IOException {
        try {
            Set<String> uniqueWords = getUniqueWords("src/main/resources/input.txt");
            Set<String> requiredLengthWords = getRequiredLengthWords(uniqueWords, 6);
            Set<String> reducedWords = getReducedWords(uniqueWords, 5);
            Set<String> possibleWordCombinations = getPossibleWordCombinations(reducedWords, 6);
            Set<String> solutionList = getValidCombination(requiredLengthWords, possibleWordCombinations);
            return solutionList;
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while processing the data", e);
        }

    }

    public Set<String> getUniqueWords(String filePath) throws IOException {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("Invalid filePath. Please provide a valid file path.");
        }
        return FileReader.loadWordList(filePath);
    }

    public Set<String> getRequiredLengthWords(Set<String> words, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Invalid length value. Length must be a positive integer.");
        }
        return FileHelper.filterWordsByLength(words, length);
    }

    public Set<String> getReducedWords(Set<String> words, int maxLength) {
        if (maxLength <= 0) {
            throw new IllegalArgumentException("Invalid maxLength value. Length must be a positive integer.");
        }
        return FileHelper.reduceWordsToMaxWordLength(words, maxLength);
    }

    public Set<String> getPossibleWordCombinations(Set<String> words, int wordLength) {
        if (wordLength <= 0) {
            throw new IllegalArgumentException("Invalid wordLength value. Length must be a positive integer.");
        }
        return WordCombiner.generatePossibleCombinations(words, wordLength);
    }

    public Set<String> getValidCombination(Set<String> possibleSolutions, Set<String> possibleCombinations) {
        return WordValidator.validateCombinations(possibleSolutions, possibleCombinations);
    }

}
