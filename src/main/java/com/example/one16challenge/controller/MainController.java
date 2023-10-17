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
        Set<String> uniqueWords = mainService.getUniqueWords("src/main/resources/input.txt");
        return ResponseEntity.ok(uniqueWords);
    }

    @GetMapping("/required-length-words")
    public ResponseEntity<Set<String>> getRequiredLengthWords() throws IOException {
        Set<String> requiredLengthWords = mainService.getRequiredLengthWords(mainService.getUniqueWords("src/main/resources/input.txt"), 6);
        return ResponseEntity.ok(requiredLengthWords);
    }

    @GetMapping("/reduced-words")
    public ResponseEntity<Set<String>> getReducedWords() throws IOException {
        Set<String> reducedWords = mainService.getReducedWords(mainService.getUniqueWords("src/main/resources/input.txt"), 5);
        return ResponseEntity.ok(reducedWords);
    }

    @GetMapping("/possible-combinations")
    public ResponseEntity<Set<String>> getPossibleWordCombinations() throws IOException {
        Set<String> possibleWordCombinations = mainService.getPossibleWordCombinations(mainService.getReducedWords(mainService.getUniqueWords("src/main/resources/input.txt"),6),6);
        return ResponseEntity.ok(possibleWordCombinations);
    }

}
