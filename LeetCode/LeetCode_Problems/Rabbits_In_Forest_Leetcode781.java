package LeetCode_Problems;

public class Rabbits_In_Forest_Leetcode781 {
    public static void main(String[] args) {
        int[] answers1 = { 1, 1, 2 };
        int[] answers2 = { 10, 10, 10 };
        System.out.println(numRabbits(answers1)); // Output: 5
        System.out.println(numRabbits(answers2)); // Output: 11
    }

    public static int numRabbits(int[] answers) {
        int ans = 0;
        int[] count = new int[1001];
        for (int i = 0; i < answers.length; i++) {
            count[answers[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                ans += (i + 1) * ((count[i] + i) / (i + 1));
            }
        }
        return ans;
    }
}
