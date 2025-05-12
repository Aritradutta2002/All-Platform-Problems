package LeetCode;

import java.util.*;

public class Number_Of_Equivalent_Domino_Pairs_Leetcode1128 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] dominoes1 = { { 1, 2 }, { 2, 1 }, { 3, 4 }, { 5, 6 } };
        int[][] dominoes2 = { { 1, 2 }, { 1, 2 }, { 1, 1 }, { 1, 2 }, { 2, 2 } };

        System.out.println(numEquivDominoPairs(dominoes1)); // Output: 1
        System.out.println(numEquivDominoPairs(dominoes2)); // Output: 3
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int result = 0;

        for (int[] d : dominoes) {
            int a = d[0], b = d[1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int num = a * 10 + b;
            result += count[num];
            count[num]++;
        }

        return result;

    }
}
