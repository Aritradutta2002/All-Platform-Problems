package LeetCode_Problems;

import java.io.*;
import java.util.*;

public class CountSubarrays {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());

        // Read nums and track the global max in one pass
        int[] nums = new int[n];
        st = new StringTokenizer(in.readLine());
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (nums[i] > maxVal) {
                maxVal = nums[i];
            }
        }

        int k = Integer.parseInt(in.readLine().trim());
        System.out.println(countSubarrays(nums, maxVal, k));
    }

    /**
     * Counts how many subarrays of nums have the global maximum (maxVal)
     * appearing at least k times.
     */

    public static long countSubarrays(int[] nums, int maxVal, int k) {
        int n = nums.length;
        long result = 0;
        int countMax = 0;
        int right = 0;

        // Slide the window [left..right)
        for (int left = 0; left < n; left++) {
            // Expand right until we have k occurrences of maxVal
            while (right < n && countMax < k) {
                if (nums[right++] == maxVal) {
                    countMax++;
                }
            }
            // If we never reached k, no further windows will either
            if (countMax < k) {
                break;
            }
            // All subarrays starting at 'left' with end in [right-1..n-1] are valid
            result += (n - right + 1);

            // Before moving left forward, remove its contribution
            if (nums[left] == maxVal) {
                countMax--;
            }
        }
        return result;
    }
}
