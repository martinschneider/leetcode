package io.github.martinschneider.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/permutations-ii/
public class LC0047_Permutations2 {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.addAll(perm(new HashSet<List<Integer>>(), nums, 0));
    return result;
}

private Set<List<Integer>> perm(Set<List<Integer>> result, int[] nums, int start)
{
    for (int i=start; i<nums.length; i++)
    {
        swap(nums, start, i);
        perm(result, nums, start + 1);
        swap(nums, start, i);
    }
    if (start >= nums.length)
    {
        result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
    return result;
}

private void swap(int[] arr, int i, int j)
{
    if (i!=j)
    {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
}
