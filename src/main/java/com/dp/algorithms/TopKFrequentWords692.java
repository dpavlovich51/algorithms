package com.dp.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentWords692 {

    public List<String> topKFrequent(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.toMap(it -> it,
                        it -> 1,
                        Integer::sum)).entrySet().stream()
                .sorted((v1, v2) -> {
                    int cv = v2.getValue() - v1.getValue();
                    if (cv != 0) return cv;
                    return v1.getKey().compareTo(v2.getKey());
                })
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static class Pair {
        private final String word;
        private final Integer count;

        public Pair(Integer count, String word) {
            this.count = count;
            this.word = word;
        }
    }
}
