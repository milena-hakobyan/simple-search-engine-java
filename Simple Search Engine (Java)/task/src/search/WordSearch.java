package search;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public interface WordSearch {
    public void find(Map<String, Set<Integer>> map, ArrayList<String> data, String line);
}
