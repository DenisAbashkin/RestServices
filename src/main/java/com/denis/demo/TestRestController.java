package com.denis.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/test_services")
public class TestRestController {

    @GetMapping("/duplicate_characters")
    public RestResponse duplicate_characters(String inputString) {
        RestResponse result = new RestResponse();

        /*String recurringCharacters = String.valueOf(inputString
                .chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()))
        );*/

        String inputStringLower = inputString.toLowerCase(Locale.ROOT);
        char[] strArr = inputStringLower.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : strArr) {
            // We don't need to count spaces
            if (c == ' ')
                continue;
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }

        Set<Map.Entry<Character, Integer>> countSet = countMap.entrySet();
        Set<Map.Entry<Character, Integer>> filteredSet = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : countSet) {
            if (entry.getValue() > 1) {
                filteredSet.add(entry);
            }
        }

        result.setInputString(inputString);
        result.setRecurringCharacters(String.valueOf(filteredSet));

        return result;
    }

    @GetMapping("/counter_word")
    public RestResponse counter_word(String inputString, String inputWord) {
        RestResponse result = new RestResponse();

        String inputStringLower = inputString.toLowerCase(Locale.ROOT);
        result.setInputString(inputString);
        result.setInputWord(inputWord);
        result.setCountWord(String.valueOf(Arrays.stream(inputStringLower.split("[ ,\\.]")).filter(s -> s.equals(inputWord)).count()));

        return result;
    }
}
