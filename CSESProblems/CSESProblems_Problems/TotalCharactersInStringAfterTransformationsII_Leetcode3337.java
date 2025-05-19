package CSESProblems_Problems;

import java.util.*;

public class TotalCharactersInStringAfterTransformationsII_Leetcode3337 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int t = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            nums.add(sc.nextInt());
        }
        sc.close();
        System.out.println(lengthAfterTransformations(s, t, nums));
    }

    private static final int MOD = 1_000_000_007;

    public static int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[][] singleStep = buildTransformationMatrix(nums);
        int[][] tStep = matrixPower(singleStep, t);

        int[] initialFreq = new int[26];
        for (char c : s.toCharArray()) {
            initialFreq[c - 'a']++;
        }

        int[] finalArray = new int[26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                finalArray[i] = (int) ((finalArray[i] + (1L * tStep[i][j] * initialFreq[j]) % MOD) % MOD);
            }
        }

        int stringSize = 0;
        for (int i = 0; i < 26; i++) {
            stringSize = (stringSize + finalArray[i]) % MOD;
        }

        return stringSize;
    }

    private static int[][] buildTransformationMatrix(List<Integer> nums) {
        int[][] matrix = new int[26][26];
        for (int i = 0; i < 26; i++) {
            // Update column for each transformation
            for (int j = i + 1; j <= i + nums.get(i); j++) {
                matrix[j % 26][i]++;
            }
        }
        return matrix;
    }

    private static int[][] matrixPower(int[][] base, int exp) {
        int n = base.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }
        int[][] cur = base;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiplyMatrices(result, cur);
            }
            cur = multiplyMatrices(cur, cur);
            exp >>= 1;
        }
        return result;
    }

    private static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long sum = 0;
                for (int k = 0; k < n; k++) {
                    sum = (sum + (long) A[i][k] * B[k][j]) % MOD;
                }
                res[i][j] = (int) sum;
            }
        }
        return res;
    }
}
