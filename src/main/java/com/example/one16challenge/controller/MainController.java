package com.example.one16challenge.controller;

import com.example.one16challenge.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private MainService mainService;

    @RequestMapping(method = RequestMethod.GET, path = "/time")
    public String displayCurrentTime(){
        return LocalDateTime.now().toString();
    }

    @GetMapping("/solution")
    public ResponseEntity<Set<String>> getSolution() throws IOException {
        Set<String> solutionList = mainService.getSolution();
        return ResponseEntity.ok(solutionList);
    }

    @GetMapping("/unique-words")
    public ResponseEntity<Set<String>> getUniqueWords() throws IOException {
        Set<String> uniqueWords = mainService.getUniqueWords();
        return ResponseEntity.ok(uniqueWords);
    }

    @GetMapping("/valid-words")
    public ResponseEntity<Set<String>> getValidWords() throws IOException {
        Set<String> validWords = mainService.getValidWords();
        return ResponseEntity.ok(validWords);
    }

    @GetMapping("/filtered-words")
    public ResponseEntity<Set<String>> getFilteredWords() throws IOException {
        Set<String> filteredWords = mainService.getFilteredWords();
        return ResponseEntity.ok(filteredWords);
    }

    @GetMapping("/possible-combinations")
    public ResponseEntity<Set<String>> getPossibleWordCombinations() throws IOException {
        Set<String> possibleWordCombinations = mainService.getPossibleWordCombinations();
        return ResponseEntity.ok(possibleWordCombinations);
    }

}
