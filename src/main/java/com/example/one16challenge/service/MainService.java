package com.example.one16challenge.service;

import com.example.one16challenge.model.FileHelper;
import com.example.one16challenge.model.FileReader;
import com.example.one16challenge.model.WordCombiner;
import com.example.one16challenge.model.WordValidator;
import com.example.one16challenge.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;


@Service
public class MainService {

    @Value("${input.file.path}") // Inject the file path from application.properties
    private String inputFilePath;

    @Value("${word.length}")
    private int wordLength;

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
            //Filter the words of the required length to check if present
            Set<String> requiredLengthWords = getRequiredLengthWords();

            //Filter the words that are a possible combination and combine them
            Set<String> possibleWordCombinations = getPossibleWordCombinations();

            //Match the words
            Set<String> solutionList = getValidCombinations(requiredLengthWords, possibleWordCombinations);

            return solutionList;
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while processing the data", e);
        }

    }

    //Load the words from the input file
    public Set<String> getUniqueWords() throws IOException {
        ValidationUtil.checkValidFilePath(inputFilePath);
        return FileReader.loadWordList(inputFilePath);
    }

    //Filter the words of the required length to check if present
    public Set<String> getRequiredLengthWords() throws IOException {
        ValidationUtil.checkValidWordLength(wordLength);
        Set<String> uniqueWords = getUniqueWords();
        return FileHelper.filterWordsByLength(uniqueWords, wordLength);
    }

    //Filter out the words that are of the required wordlength (because they cant be combined)
    public Set<String> getReducedWords() throws IOException {
        ValidationUtil.checkValidWordLength(wordLength);
        Set<String> uniqueWords = getUniqueWords();
        return FileHelper.reduceWordsToMaxWordLength(uniqueWords, wordLength);
    }

    //Filter the words that are a possible combination
    public Set<String> getPossibleWordCombinations() throws IOException {
        ValidationUtil.checkValidWordLength(wordLength);
        Set<String> reducedWords = getReducedWords();
        return WordCombiner.generatePossibleCombinations(reducedWords, wordLength);
    }

    //Match the words
    public Set<String> getValidCombinations(Set<String> requiredLengthWords, Set<String> possibleWordCombinations) {
        return WordValidator.validateCombinations(requiredLengthWords, possibleWordCombinations);
    }

}
