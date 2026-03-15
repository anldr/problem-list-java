package leetcode.Vol101to200;

import java.util.*;

public class LeetCode127 {
    private int num = 0;

    private Map<String, Integer> idMap = new HashMap<>();

    private List<List<Integer>> edges = new ArrayList<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        addEdge(beginWord);
        for (String word : wordList) {
            addEdge(word);
        }

        if (!idMap.containsKey(endWord)) {
            return 0;
        }

        int[] distance = new int[num];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int beginId = idMap.get(beginWord);
        int endId = idMap.get(endWord);
        distance[beginId] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(beginId);
        while (!queue.isEmpty()) {
            int id = queue.poll();
            if (id == endId) {
                return distance[endId] / 2 + 1;
            }
            List<Integer> toEdge = edges.get(id);
            for (int edgeId : toEdge) {
                if (distance[edgeId] == Integer.MAX_VALUE) {
                    distance[edgeId] = distance[id] + 1;
                    queue.add(edgeId);
                }
            }
        }

        return 0;
    }

    private void addEdge(String word) {
        addWord(word);
        int wordId = idMap.get(word);
        char[] array = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            array[i] = '*';
            String newEdge = String.valueOf(array);
            addWord(newEdge);
            int edgeId = idMap.get(newEdge);
            edges.get(wordId).add(edgeId);
            edges.get(edgeId).add(wordId);
            array[i] = tmp;
        }
    }

    private void addWord(String word) {
        if (!idMap.containsKey(word)) {
            idMap.put(word, num++);
            edges.add(new ArrayList<>());
        }
    }
}