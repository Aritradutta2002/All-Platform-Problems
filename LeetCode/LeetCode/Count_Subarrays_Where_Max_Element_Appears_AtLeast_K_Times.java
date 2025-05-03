package LeetCode;

import java.util.*;

public class Count_Subarrays_Where_Max_Element_Appears_AtLeast_K_Times {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(countSubarrays(nums, k));
    }

    public static long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        long ans = 0;
        int count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        for (var x : nums) {
            while (j < n && count < k) {
                count += (nums[j] == max) ? 1 : 0;
                j++;
            }
            if (count < k) {
                break;
            }
            ans += n - j + 1;
            count -= x == max ? 1 : 0;
        }
        return ans;
    }
}
