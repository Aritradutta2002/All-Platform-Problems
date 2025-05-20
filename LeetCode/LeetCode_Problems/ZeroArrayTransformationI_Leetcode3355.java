package LeetCode_Problems;

import java.util.*;

public class ZeroArrayTransformationI_Leetcode3355 {

    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int size = ip.nextInt();
        int nums[] = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = ip.nextInt();
        }
        int queries = ip.nextInt();
        int queriesArray[][] = new int[queries][2];
        for (int i = 0; i < queries; i++) {
            queriesArray[i][0] = ip.nextInt();
            queriesArray[i][1] = ip.nextInt();
        }

        System.out.println(isZeroArray(nums, queriesArray));
    }

    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int[] deltaArray = new int[nums.length + 1];
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            deltaArray[left] += 1;
            deltaArray[right + 1] -= 1;
        }
        int[] operationCounts = new int[deltaArray.length];
        int currentOperations = 0;
        for (int i = 0; i < deltaArray.length; i++) {
            currentOperations += deltaArray[i];
            operationCounts[i] = currentOperations;
        }
        for (int i = 0; i < nums.length; i++) {
            if (operationCounts[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
