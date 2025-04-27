package LeetCode;
import java.util.*;
@SuppressWarnings("unused")
public class Count_the_Number_of_Fair_Pairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int lower = sc.nextInt();
        int upper = sc.nextInt();
        System.out.println(countFairPairs(nums, lower, upper));
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        
        for (int i = 0; i < n - 1; i++){
            int upperBound = upper_bound(nums, i + 1, n, upper - nums[i]);
            int lowerBound = lower_bound(nums, i + 1, n, lower - nums[i]);
            ans += (upperBound - lowerBound);
        }

        return (long) ans;
    }
    
    static int lower_bound(int arr[], int start, int N, int X){
        int mid, low = start, high = N;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (X <= arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (low < N && arr[low] < X) {
            low++;
        }
        return low;
    }

    static int upper_bound(int arr[], int start, int N, int X){
        int mid;
        int low = start, high = N;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (X >= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (low < N && arr[low] <= X) {
            low++;
        }
        return low;
    }
}
