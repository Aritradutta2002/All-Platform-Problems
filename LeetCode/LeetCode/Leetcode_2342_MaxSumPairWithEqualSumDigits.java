package LeetCode;
import java.util.*;
public class Leetcode_2342_MaxSumPairWithEqualSumDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maximumSum(arr));
    }

    static public int maximumSum(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        int map [] = new int[82];
        int ans = -1;

        for(int ele : nums) {
            int digitSum = getDigitSum(ele);

            if(map[digitSum] > 0) {
                int prev = map[digitSum];
                //int prev = map.get(digitSum);
                ans = Math.max(ans, ele + prev);
                map[digitSum] = Math.max(ele, prev);
                //map.put(digitSum, Math.max(ele, prev));
            }
            else{
                map[digitSum] = ele;
                //map.put(digitSum, ele);
            }

        }

        return ans;
        
    }

    static public int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}