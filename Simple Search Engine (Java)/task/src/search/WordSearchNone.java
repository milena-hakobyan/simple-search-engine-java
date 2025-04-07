package search;

import java.util.*;

public class WordSearchNone implements WordSearch{
    @Override
    public void find(Map<String, Set<Integer>> map, ArrayList<String> data, String line) {
        String[] words = line.split("\\s+"); // split the initial input into words

        Set<String> wordSet = new HashSet<>(); //words from the query
        Collections.addAll(wordSet, words);

        Set<Integer> lineNumbers = new TreeSet<>();
        for(String word: map.keySet()) {
            if(wordSet.contains(word)){
                for(Integer i : map.get(word))
                    lineNumbers.add(i);
            }
        }

        for(int i = 0; i < data.size(); i++){
            if(!lineNumbers.contains(i))
                System.out.println(data.get(i));
        }
    }
}
