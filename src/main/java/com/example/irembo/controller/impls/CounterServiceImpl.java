package com.example.irembo.controller.impls;

import com.example.irembo.controller.CounterService;
import com.example.irembo.controller.Helper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CounterServiceImpl implements CounterService {

    @Override
    public String count(String[] fruits) {
        if (fruits == null || fruits.length == 0) return "";
        StringBuilder result = new StringBuilder();
        SortedMap<Character, Integer> output = new TreeMap<>();
        Helper.populateMapWithAllAlphabets(ch -> output.put(ch, 0));
        Arrays.stream(fruits).forEach(fruit -> {
            char firstCharacter = fruit.charAt(0);
            Integer count = output.get(firstCharacter);
            output.put(firstCharacter, count + 1);
        });
        output.forEach((character, integer) -> result.append(character + ":" + integer).append("\n"));
        return result.toString();
    }

    @Override
    public String enhancedCount(String[] fruits) {
        if (fruits == null || fruits.length == 0) return "";
        SortedMap<Character, List<String>> output = new TreeMap<>();
        Helper.populateMapWithAllAlphabets(ch -> output.put(ch, new ArrayList<>()));
        Arrays.stream(fruits).forEach(fruit -> {
            char firstCharacter = fruit.charAt(0);
            List<String> relatedFruits = output.get(firstCharacter);
            relatedFruits.add(fruit);
            output.put(firstCharacter, relatedFruits);
        });
        return printEnhancedSortedFruit(output);
    }

    private String printEnhancedSortedFruit(SortedMap<Character, List<String>> sorted) {
        StringBuilder result = new StringBuilder();
        sorted.forEach((character, relatedFruits) -> {
            result.append(character).append(":").append(relatedFruits.size()).append("\n");
            Map<String, Integer> visited = new HashMap<>();
            for (String currentFruit : relatedFruits) {
                if (visited.containsKey(currentFruit)) {
                    int visitedCount = visited.get(currentFruit) + 1;
                    visited.put(currentFruit, visitedCount);
                } else {
                    visited.put(currentFruit, 1);
                }
            }
            visited.forEach((s, integer) -> result.append(integer).append(" ").append(s).append("\n"));
        });
        return result.toString();
    }

}
