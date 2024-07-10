package com.test.normalizer;

import com.test.domain.WordData;
import com.test.filereader.MyFileReaderToStringArray;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Normalizer {

    /**
     * Receives a list of normalized job titles. For this test, I chose to read from a text file in the project's root.
     */
    private static final String[] normalizedJobTitles = MyFileReaderToStringArray.readMyNormalizedJobTitles();


    /**
     * Receives a String with the non-normalized job title and returns a normalized String.
     * @param input
     * @return
     */
    public String normalize(String input) {
        String[] inputWords = input.toLowerCase().split("\\s+");
        List<WordData> wordDataList = new ArrayList<>();
        for (String word : inputWords) {
            for (String normalizedS : normalizedJobTitles) {
                WordData w = new WordData();
                w.setOriginalString(input);
                w.setComparateTo(normalizedS);
                w.setQuality(calculateSimilarity(word, normalizedS));
                wordDataList.add(w);
            }
        }
            wordDataList = wordDataList.stream()
                    .sorted(Comparator.comparing(WordData::getQuality).reversed())
                    .collect(Collectors.toList());

        return (wordDataList.get(0)!= null && wordDataList.get(0).getQuality() > 0.0) ? wordDataList.get(0).getComparateTo() : input;
    }

    /**
     * Compares the input Strings with the normalized ones and returns a value.
     * @param word1
     * @param word2
     * @return
     */
    public static double calculateSimilarity(String word1, String word2) {
        String[] word2Splited = word2.split("\\s+");
        double pontuacao =  0.0;
        for (String s : word2Splited){
            if (word1.toLowerCase().equals(s.toLowerCase())){
                pontuacao+=1.0;
                continue;
            }
        }
        return pontuacao;
    }

    public static void main(String[] args) {
        Normalizer n = new Normalizer();
        System.out.println("Normalized: " + n.normalize("Java engineer"));
        System.out.println("Normalized: " + n.normalize("C# engineer"));
        System.out.println("Normalized: " + n.normalize("Accountant"));
        System.out.println("Normalized: " + n.normalize("Chief Accountant"));
        System.out.println("Normalized: " + n.normalize("Infant Magician"));
        System.out.println("Normalized: " + n.normalize("Mechanical"));

    }
}




