package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
public class LC1333_FilterRestaurantsByVeganFriendlyPriceAndDistance {
  public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
    Arrays.sort(restaurants, new java.util.Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            int result=Integer.compare(b[1], a[1]);
            if (result==0)
            {
                result=Integer.compare(b[0], a[0]);
            }
            return result;
        }
    });
    List<Integer> result = new ArrayList<>();
    for (int[] restaurant : restaurants)
    {
        if (restaurant[3]<=maxPrice && restaurant[4]<=maxDistance && restaurant[2]-veganFriendly>=0)
        {
            result.add(restaurant[0]);
        }
    }
    return result;
}
}
