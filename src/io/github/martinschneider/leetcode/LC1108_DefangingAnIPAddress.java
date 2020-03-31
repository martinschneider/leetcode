package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/defanging-an-ip-address/
public class LC1108_DefangingAnIPAddress {
  public String defangIPaddr(String address) {
    return address.replaceAll("\\.", "[.]");
  }
}
