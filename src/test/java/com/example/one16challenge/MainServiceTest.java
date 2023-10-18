package com.example.one16challenge;

import com.example.one16challenge.service.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = "classpath:/application.properties")
public class MainServiceTest {
    @Autowired
    private MainService mainService;

    @Test
    public void testGetUniqueWords() throws IOException {
        Set<String> uniqueWords = mainService.getUniqueWords();
        Set<String> expected = new HashSet<>(Set.of("5charo", "bar", "baro", "5char", "foobar", "barfoo", "foo", "longword", "o"));

        assertEquals(expected, uniqueWords);
    }
    @Test
    public void testGetValidWords() throws IOException {
        Set<String> validWords = mainService.getValidWords();
        Set<String> expected = new HashSet<>(Set.of("foobar", "barfoo","5charo"));

        assertEquals(expected, validWords);
    }

    @Test
    public void testGetFilteredWords() throws IOException {
        Set<String> validWords = mainService.getFilteredWords();
        Set<String> expected = new HashSet<>(Set.of("bar", "baro","5char", "foo", "o"));

        assertEquals(expected, validWords);
    }

    @Test
    public void testGetPossibleWordCombinations() throws IOException {
        Set<String> possibleWordCombinations = mainService.getPossibleWordCombinations();
        Set<String> expected = new HashSet<>(Set.of("o+5char=o5char", "bar+foo=barfoo", "foo+bar=foobar", "5char+o=5charo"));

        assertEquals(expected, possibleWordCombinations);
    }

    @Test
    public void testGetSolution() throws IOException {
        Set<String> solutionList = mainService.getSolution();
        Set<String> expected = new HashSet<>(Set.of("bar+foo=barfoo", "foo+bar=foobar", "5char+o=5charo"));

        assertEquals(expected, solutionList);
    }


}


