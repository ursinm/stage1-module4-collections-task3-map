package com.epam.mjc.collections.map;

import java.util.HashMap;
import java.util.Map;

public class WordRepetitionMapCreator {

    public Map<String, Integer> createWordRepetitionMap(String sentence) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        // Убираем пунктуацию и разбиваем строку на слова
        String[] words = sentence.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
        
        // Считаем количество вхождений каждого слова
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
        
        return wordCountMap;
    }
}
