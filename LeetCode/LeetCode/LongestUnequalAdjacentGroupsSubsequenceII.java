package LeetCode;
import java.util.*;

/**
 * LeetCode 2901: Longest Unequal Adjacent Groups Subsequence II
 * 
 * Problem: Given strings words and groups where words[i] corresponds to groups[i],
 * find the longest subsequence such that adjacent words are unequal
 * and the Hamming distance between them is 1.
 */
public class LongestUnequalAdjacentGroupsSubsequenceII {
    public List<Integer> getWordsInLongestSubsequence(int n, String[] words, String[] groups) {
        // Handle edge cases
        if (n == 0) {
            return new ArrayList<>();
        }
        
        // DP array to store the longest subsequence ending at each index
        int[] dp = new int[n];
        // Previous index array to reconstruct the subsequence
        int[] prev = new int[n];
        
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        
        int maxLength = 1;
        int endIndex = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if words[i] and words[j] can be adjacent in the subsequence
                if (groups[i].equals(groups[j])) {
                    continue; // Skip if they are in the same group
                }
                
                // Check if Hamming distance is 1 and words have the same length
                if (words[i].length() == words[j].length() && 
                    hammingDistance(words[i], words[j]) == 1 && 
                    dp[j] + 1 > dp[i]) {
                    
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                    
                    if (dp[i] > maxLength) {
                        maxLength = dp[i];
                        endIndex = i;
                    }
                }
            }
        }
        
        // Reconstruct the subsequence
        List<Integer> result = new ArrayList<>();
        while (endIndex != -1) {
            result.add(0, endIndex);
            endIndex = prev[endIndex];
        }
        
        return result;
    }
    
    // Calculate Hamming distance between two strings
    private int hammingDistance(String a, String b) {
        if (a.length() != b.length()) {
            return -1; // Cannot calculate Hamming distance for strings of different lengths
        }
        
        int distance = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                distance++;
            }
        }
        
        return distance;
    }
    
    // Example usage
    public static void main(String[] args) {
        LongestUnequalAdjacentGroupsSubsequenceII solution = new LongestUnequalAdjacentGroupsSubsequenceII();
        
        // Example test case
        String[] words = {"bab", "dab", "cab"};
        String[] groups = {"a", "b", "c"};
        List<Integer> result = solution.getWordsInLongestSubsequence(words.length, words, groups);
        
        System.out.println("Indices of longest subsequence: " + result);
        System.out.print("Words in longest subsequence: ");
        for (int index : result) {
            System.out.print(words[index] + " ");
        }
    }
} 