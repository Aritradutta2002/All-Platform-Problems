
import java.util.Scanner;
public class TupleWithSameProduct_LeetCode1726 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(tupleSameProduct(arr));
    }

    static public int tupleSameProduct(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] * nums[j] == nums[j + 1] * nums[i + 1]) {
                    count++;
                }
            }
        }
        return count;
    }
}