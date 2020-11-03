package pers.tavish.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

/**

 Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".


 Example 1:

 Input: strs = ["flower","flow","flight"]
 Output: "fl"

 Example 2:

 Input: strs = ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.


 Constraints:

 - 0 <= strs.length <= 200
 - 0 <= strs[i].length <= 200
 - strs[i] consists of only lower-case English letters.

 */

public class LongestCommonPrefix {

//    public String longestCommonPrefix(String[] strs) {
//        return strs == null || strs.length == 0 ? "" : lcp(strs, 0, strs.length - 1);
//    }
//
//    private String lcp(String[] strs, int lo, int hi) {
//        if (lo == hi) {
//            return strs[lo];
//        }
//        int mid = lo + (hi - lo >>> 1);
//        return lcp(lcp(strs, lo, mid), lcp(strs, mid + 1, hi));
//    }
//
//    private String lcp(String str1, String str2) {
//        int length = Math.min(str1.length(), str2.length());
//        for (int i = 0; i < length; i++) {
//            if (str1.charAt(i) != str2.charAt(i)) {
//                return str1.substring(0, i);
//            }
//        }
//        return str1.substring(0, length);
//    }

     public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix;
    }

    @Test
    public void testCase() {
        String[] strs = {"flower","flow","flight"};
        Assert.assertEquals("fl", longestCommonPrefix(strs));
    }

}
