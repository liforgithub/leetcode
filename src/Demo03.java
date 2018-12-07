import java.util.ArrayList;
import java.util.List;

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/
public class Demo03 {

//    public static int lengthOfLongestSubstring(String s) {
//        int maxLength = 0;
//        int sLength = s.length();
//        for (int i = 0; i < sLength; i++) {
//            List<Integer> charList = new ArrayList<>();
//            for (int j = i; j < sLength; j++) {
//                int ascNum = (int) s.charAt(j);
//                if (charList.contains(ascNum)) break;
//                charList.add(ascNum);
//                maxLength = Math.max(maxLength, charList.size());
//            }
//        }
//        return maxLength;
//    }


    //优化代码
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        String s1 = "au";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        int res1 = lengthOfLongestSubstring(s1);
        int res2 = lengthOfLongestSubstring(s2);
        int res3 = lengthOfLongestSubstring(s3);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
