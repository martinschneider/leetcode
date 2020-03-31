package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
public class LC1371_FindTheLongestSubstringContainingVowelsInEvenCounts {
  public int findTheLongestSubstring(String s) {
    char[] array = s.toCharArray();
    for (int k = array.length; k > 0; k--) {
      for (int i = 0; i + k <= array.length; i++) {
        if (checkVowels(array, i, k)) {
          return k;
        }
      }
    }
    return 0;
  }

  private boolean checkVowels(char[] array, int start, int length) {
    int a = 0;
    int e = 0;
    int i = 0;
    int o = 0;
    int u = 0;
    for (int j = start; j < start + length; j++) {
      switch (array[j]) {
        case 'a':
          a++;
          break;
        case 'e':
          e++;
          break;
        case 'i':
          i++;
          break;
        case 'o':
          o++;
          break;
        case 'u':
          u++;
          break;
      }
    }
    return (a % 2 == 0 && e % 2 == 0 && i % 2 == 0 && o % 2 == 0 && u % 2 == 0);
  }
}
