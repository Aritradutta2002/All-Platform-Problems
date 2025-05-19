package LeetCode_Problems;

import java.util.*;

@SuppressWarnings("unused")

public class TotalCharactersInStringAfterTransformationsI_Leetcode3335 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();

        System.out.println("Result for " + str + " is : " + lengthAfterTransformations(str, k));
        // System.out.println("Result for abcyy is : " +
        // lengthAfterTransformations("abcyy", 2)); // output -> 7
        // System.out.println("Result for azbk is : " +
        // lengthAfterTransformations("azbk", 1)); // output -> 5
    }

    public static int lengthAfterTransformations(String s, int t) {

        final int MOD = 1_000_000_007;
        int[] dp = new int[26];
        for (char c : s.toCharArray()) {
            dp[c - 'a']++;
        }

        for (int step = 0; step < t; step++) {
            int[] next = new int[26];
            System.arraycopy(dp, 0, next, 1, 25);
            next[0] = (next[0] + dp[25]) % MOD;
            next[1] = (next[1] + dp[25]) % MOD;
            dp = next;
        }

        long ans = 0;
        for (int cnt : dp) {
            ans = (ans + cnt) % MOD;
        }
        return (int) ans;
    }
}
