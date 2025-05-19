package LeetCode_Problems;
import java.util.*;
@SuppressWarnings("unused")

public class Length_of_Longest_Subarray_With_AtMost_K_Frequency_Leetcode2958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(maxSubarrayLength(arr, k));
        int[] arr1 = { 1, 2, 3, 1, 2, 3, 1, 2 };
        int k1 = 2;
        int[] arr2 = { 1, 2, 1, 2, 1, 2, 1, 2 };
        int k2 = 1;
        int[] arr3 = { 5, 5, 5, 5, 5, 5, 5 };
        int k3 = 4;
        System.out.println(maxSubarrayLength(arr1, k1));
        System.out.println(maxSubarrayLength(arr2, k2));
        System.out.println(maxSubarrayLength(arr3, k3));
        sc.close();
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        int start = 0, maxLength = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int end = 0; end < nums.length; end++) {
            freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);

            while (freq.get(nums[end]) > k) {
                freq.put(nums[start], freq.get(nums[start]) - 1);
                if (freq.get(nums[start]) == 0) {
                    freq.remove(nums[start]);
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
