package LeetCode_Problems;

/*
 * Solved using Kadane's Algorithm
 */
import java.util.*;

public class MaximumAscendingSubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxAscendingSum(arr));
    }

    static public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {
                sum = sum + nums[i];
            }

            else {
                sum = nums[i];
            }

            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}