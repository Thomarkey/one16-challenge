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

    // Inject the used file path from application.properties
    @Value("${input.file.path}")
    private String inputFilePath;

    // Inject the required word length from application.properties
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

    //Get the valid solution for the challenge
    public Set<String> getSolution() throws IOException {
        try {
            //Filter the words of the required length
            Set<String> validWords = getValidWords();

            //Filter the words that are a possible combination and combine them
            Set<String> possibleWordCombinations = getPossibleWordCombinations();

            //Match the words
            Set<String> solutionList = getValidCombinations(validWords, possibleWordCombinations);

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

    //Get valid words based on given word length
    public Set<String> getValidWords() throws IOException {
        ValidationUtil.checkValidWordLength(wordLength);
        Set<String> uniqueWords = getUniqueWords();
        return FileHelper.filterWordsByLength(uniqueWords, wordLength);
    }

    //Filter out the words that are of the required word length (because they cant be combined)
    public Set<String> getFilteredWords() throws IOException {
        ValidationUtil.checkValidWordLength(wordLength);
        Set<String> uniqueWords = getUniqueWords();
        return FileHelper.reduceWordsToMaxWordLength(uniqueWords, wordLength);
    }

    //Filter the words that are a possible combination
    public Set<String> getPossibleWordCombinations() throws IOException {
        ValidationUtil.checkValidWordLength(wordLength);
        Set<String> filteredWords = getFilteredWords();
        return WordCombiner.generatePossibleCombinations(filteredWords, wordLength);
    }

    //Match the words and find valid combination
    public Set<String> getValidCombinations(Set<String> validWords, Set<String> possibleWordCombinations) {
        return WordValidator.validateCombinations(validWords, possibleWordCombinations);
    }

}
