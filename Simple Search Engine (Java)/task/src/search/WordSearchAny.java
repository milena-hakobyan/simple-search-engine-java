package search;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class WordSearchAny implements WordSearch {
    @Override
    public void find(Map<String, Set<Integer>> map, ArrayList<String> data, String line) {
        String[] words = line.split(" ");
        for(String word: words) {
            if(map.containsKey(word)){
                for(Integer i : map.get(word))
                    System.out.println(data.get(i));
            }
        }
    }
}
