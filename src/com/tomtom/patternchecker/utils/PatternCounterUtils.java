package com.tomtom.patternchecker.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PatternCounterUtils {
    
    public static Map<String, ?> getWordCounts(ArrayList<String> content){
        ArrayList<String> words = (ArrayList<String>) content.stream()
                .collect(Collectors.toList());
        words.removeIf(e -> (isNumeric(e)));
        Map<String, Long> result = words.stream().map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return result;
    }

    public static Map<String, ?> getNumberCounts(ArrayList<String> content){
        System.out.println("test 2"+content);
        content.removeIf(e -> !(isNumeric(e)));
        Map<String, Long> result = content.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return result;
    }

    public static HashMap<String, Integer> getPhraseCounts(ArrayList<String> content) throws Exception{
        System.out.println("test 3"+content);

        ArrayList<String> lowercaseStrings = (ArrayList<String>) content.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        HashMap<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < lowercaseStrings.size() - 2; i++) {
            String phrase = lowercaseStrings.get(i) + " " +lowercaseStrings.get(i+1) + " " +lowercaseStrings.get(i+2);
            int count = counts.getOrDefault(phrase, 0);
            counts.put(phrase, count + 1);
        }
        return counts;
    }

    public static HashMap<String, Map<String, ?>> getAllPattern(ArrayList<String> content) throws Exception {
        HashMap<String, Map<String, ?>> notificationItem = new HashMap<>();
        notificationItem.put("WORD COUNTS", getWordCounts(content));
        notificationItem.put("NUMERIC COUNTS", getNumberCounts(content));
        notificationItem.put("PHRASE COUNTS", getPhraseCounts(content));
        return notificationItem;
    }


    /**
     * @param str input to check
     * @return if value is numeric or not in Boolean
     */

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * @param filePath input of the path from the user
     * @return strings in list from the read path file
     */
    public static ArrayList<String> stringToArrayList(String filePath) throws IOException {
        ArrayList<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(" ");
            Collections.addAll(words, split);

        }
        reader.close();
        return words;
    }
}
