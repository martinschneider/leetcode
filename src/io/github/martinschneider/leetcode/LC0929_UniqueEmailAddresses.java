package io.github.martinschneider.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/unique-email-addresses
public class LC0929_UniqueEmailAddresses {
  public int numUniqueEmails(String[] emails) {
    Set<String> set = new HashSet<String>();
    for (String email : emails) {
      set.add(normaliseEmail(email));
    }
    return set.size();
  }

  private String normaliseEmail(String email) {
    int idx = email.indexOf('@');
    String local = email.substring(0, idx);
    String domain = email.substring(idx + 1, email.length());

    local = local.replaceAll("\\.", "");
    idx = local.indexOf('+');
    if (idx != -1) {
      local = local.substring(0, idx);
    }
    System.out.println(local + domain);
    return local + '@' + domain;
  }
}
