import java.lang.*;
import java.util.*;
public class Count_Subarrays_With_Fixed_Bounds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = sc.nextInt();
        int max = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(countSubarrays(arr, min, max));
    }
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long total = 0;
        int lastInvalid = -1, lastMin = -1, lastMax = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) lastInvalid = i;
            if (nums[i] == minK) lastMin = i;
            if (nums[i] == maxK) lastMax = i;

            int validStart = Math.min(lastMin, lastMax);
            total += Math.max(0, validStart - lastInvalid);
        }

        return total;
    }

}