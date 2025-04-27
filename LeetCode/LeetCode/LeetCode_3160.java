package LeetCode;
import java.util.*;
@SuppressWarnings("unused")

public class LeetCode_3160 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [][] queries = new int[n][2];
    }

    static public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;

        HashMap<Integer, Integer> ballColor = new HashMap<>(); // Color of each ball
        HashMap<Integer, Integer> colorFrequency = new HashMap<>(); // Frequency of each color
        Set<Integer> distinctColors = new HashSet<>(); // Set to keep track of distinct colors

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColor.containsKey(ball)) {
                int prevColor = ballColor.get(ball);
                colorFrequency.put(prevColor, colorFrequency.get(prevColor) - 1);
                if (colorFrequency.get(prevColor) == 0) {
                    distinctColors.remove(prevColor);
                }
            }

            ballColor.put(ball, color);
            colorFrequency.put(color, colorFrequency.getOrDefault(color, 0) + 1);
            distinctColors.add(color);

            result[i] = distinctColors.size();
        }

        return result;
    }

}