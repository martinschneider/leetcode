package io.github.martinschneider.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/encode-and-decode-tinyurl/
public class LC0535_EncodeAndDecodeTinyURL {
  private Map<String, String> map = new HashMap<>();

  private static final String CHARACTER_SET =
      "abcdefghjklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

  private static final int LENGTH = 6;

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    String key = null;
    do {
      key = getRandomKey();
    } while (map.containsKey(key));
    map.put(key, longUrl);
    return "http://www.tinyurl.com/" + key;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    return map.get(shortUrl.replace("http://www.tinyurl.com/", ""));
  }

  private String getRandomKey() {
    StringBuilder strBuilder = new StringBuilder();
    for (int i = 0; i < LENGTH; i++) {
      strBuilder.append(CHARACTER_SET.charAt((int) (Math.random() * LENGTH) + 1));
    }
    return strBuilder.toString();
  }
}
