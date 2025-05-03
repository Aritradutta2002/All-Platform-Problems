package LeetCode;
import java.util.*;
public class Find_Numbers_with_Even_Number_Of_Digits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(findNumbers(nums));
    }
    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int i : nums){
            int len = (int) Math.log10(i) + 1;
            if(len % 2 == 0){
                count++;
            }
        }
        return count;
    }
}
