package Contests.LeetCode;
/*
 *   Author  : Aritra Dutta
 *   Created : Thursday, 05.12.2024  01:14 am
 */
import java.util.*;
public class ThreeSum {
    public static void main(String[] args) {
        Scanner fs = new Scanner(System.in);
        int n = fs.nextInt();
        int[] test1 = {-1,0,1,2,-1,-4};
        int[] test2 = {0,1,1};
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = fs.nextInt();
        }
        System.out.println(threeSum(test1));
        System.out.println(threeSum(test2));
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(triplet);
                    }
                }
            }
        }

        return result;
    }
}
