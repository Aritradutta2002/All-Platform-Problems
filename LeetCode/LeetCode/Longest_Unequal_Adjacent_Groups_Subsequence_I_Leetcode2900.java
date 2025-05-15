package LeetCode;
import java.util.*;
public class Longest_Unequal_Adjacent_Groups_Subsequence_I_Leetcode2900 {
    public static void main(String[] args) {
        int n = 4;
        String[] words = {"a", "b", "c", "d"};
        int[] groups = {1, 0, 1, 1};
        
        List<String> result = getWordsInLongestSubsequence(n, words, groups);
        System.out.println("Longest subsequence: " + result);
    }

    public static List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        result.add(words[0]);
        
        for (int i = 1; i < n; i++) {
            if (groups[i] != groups[i-1]) {
                result.add(words[i]);
            }
        }
        
        return result;
    }

}
