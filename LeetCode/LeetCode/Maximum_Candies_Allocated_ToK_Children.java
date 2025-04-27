package LeetCode;
import java.util.*;
public class Maximum_Candies_Allocated_ToK_Children {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
        }
        long k = sc.nextInt();

        System.out.println(maximumCandies(candies, k));
    }

    public static int maximumCandies(int[] candies, long k) {
        if (candies == null || candies.length == 0) {
            return 0;
        }
        long sum = candies[0];
        int maxCount = candies[0];
        int n = candies.length;
        for (int i = 1; i < n; i++) {
            maxCount = Math.max(maxCount, candies[i]);
            sum += candies[i];
        }

        if (sum < k) {
            return 0;
        }

        int left = 1;
        int right = maxCount;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(candies, mid, k)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static boolean canDistribute(int[] candies, int mid, long k) {
        long count = 0;
        for (int candy : candies) {
            count += candy / mid;
        }
        return count >= k;
    }
}
