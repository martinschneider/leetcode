package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/search-suggestions-system/
public class LC1268_SearchSuggestionsSystem {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Map<String, List<String>> lookUp = new HashMap<String, List<String>>();
    for (String product : products) {
      for (int i = 1; i <= product.length(); i++) {
        String subString = product.substring(0, i);
        List<String> results = lookUp.get(subString);
        if (results == null) {
          results = new ArrayList<String>();
        }
        results.add(product);
        lookUp.put(subString, results);
      }
    }
    List<List<String>> results = new ArrayList<List<String>>();
    for (int i = 1; i <= searchWord.length(); i++) {
      List<String> topThree = new ArrayList<String>();
      List<String> all = lookUp.get(searchWord.substring(0, i));
      if (all != null) {
        Collections.sort(all);
        Iterator<String> iter = all.iterator();
        while (iter.hasNext() && topThree.size() < 3) {
          topThree.add(iter.next().toString());
        }
      }
      results.add(topThree);
    }
    return results;
  }
}
