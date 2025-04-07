package search;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class WordSearcher {
    private WordSearch wordSearch;

    public void setMethod(WordSearch wordSearch) {
        this.wordSearch = wordSearch;
    }

    public void find(Map<String, Set<Integer>> map, ArrayList<String> data, String line){
        this.wordSearch.find(map,data,line);
    }
}
