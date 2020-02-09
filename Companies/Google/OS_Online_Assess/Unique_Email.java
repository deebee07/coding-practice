/*
Every email consists of a local name and a domain name, separated by the @ sign.

For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

Besides lowercase letters, these emails may contain '.'s or '+'s.

If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
(Note that this rule does not apply for domain names.)
Example 1:

Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails

      local = local.replaceAll("\\.", "");
*/
class Solution {
    public int numUniqueEmails(String[] emails) {
      Set<String> seen = new HashSet();
      for (String email : emails) {
        int i = email.indexOf('@');
        String local = email.substring(0, i);
        String rest = email.substring(i);
        if (local.contains("+")) {
          local = local.substring(0, local.indexOf('+'));
        }
        // Note: one should escape the specific character '.',
        // since it is treated as a regex expression.
        local = local.replaceAll("\\.", "");
        seen.add(local + rest);
      }
  
      return seen.size();
    }
  }
  