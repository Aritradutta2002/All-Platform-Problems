package LeetCode;
import java.util.*;
@SuppressWarnings("unused")

public class Leetcode_3066 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int size = ip.nextInt();
        int nums [] = new int [size];
        for(int i = 0; i < size; i++) {
            nums[i] = ip.nextInt();
        }
        int k = ip.nextInt();

        System.out.println(minOperations(nums, k));
    }

    static public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int count = 0;

        for (int num : nums) {
            pq.offer((long) num);
        }

        while (pq.size() > 1 && pq.peek() < k) {
            count++;
            
            long first = pq.poll();
            long second = pq.poll();
            pq.offer((long) Math.max(first, second) + 2 * Math.min(first, second));
        }

        if (pq.peek() >= k) {
            return count;
        } else {
            return -1;
        }
    }
}