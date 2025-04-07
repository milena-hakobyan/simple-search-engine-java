package search;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class WordSearchAll implements WordSearch{
    @Override
    public void find(Map<String, Set<Integer>> map, ArrayList<String> data, String line) {
        if(map.containsKey(line)) {
            for(Integer i : map.get(line))
                System.out.println(data.get(i));
        }
    }
}
