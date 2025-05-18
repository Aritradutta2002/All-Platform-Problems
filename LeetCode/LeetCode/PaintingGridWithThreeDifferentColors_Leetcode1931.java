package LeetCode;

import java.util.*;

public class PaintingGridWithThreeDifferentColors_Leetcode1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int result = colorTheGrid(m, n);
        System.out.println(result);
        sc.close();
    }

    private static final int MOD = 1_000_000_007;

    public static int colorTheGrid(int m, int n) {
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
        }
        
        List<Integer> validColumns = generateValidColumns(m);
        int colCount = validColumns.size();
        
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < colCount; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < colCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (canPlaceAdjacent(validColumns.get(i), validColumns.get(j), m)) {
                    adjacencyList.get(i).add(j);
                }
            }
        }
        
        long[][] dp = new long[n][colCount];
        Arrays.fill(dp[0], 1);
        
        for (int col = 1; col < n; col++) {
            for (int currConfig = 0; currConfig < colCount; currConfig++) {
                for (int prevConfig : adjacencyList.get(currConfig)) {
                    dp[col][currConfig] = (dp[col][currConfig] + dp[col-1][prevConfig]) % MOD;
                }
            }
        }
        
        long result = 0;
        for (int i = 0; i < colCount; i++) {
            result = (result + dp[n-1][i]) % MOD;
        }
        
        return (int) result;
    }
    
    private static List<Integer> generateValidColumns(int m) {
        List<Integer> validColumns = new ArrayList<>();
        generateValidColumnsHelper(0, 0, m, validColumns, -1);
        return validColumns;
    }
    
    private static void generateValidColumnsHelper(int row, int colMask, int m, List<Integer> validColumns, int prevColor) {
        if (row == m) {
            validColumns.add(colMask);
            return;
        }
        
        for (int color = 0; color < 3; color++) {
            if (color != prevColor) {
                generateValidColumnsHelper(row + 1, colMask * 3 + color, m, validColumns, color);
            }
        }
    }
    
    private static boolean canPlaceAdjacent(int col1, int col2, int m) {
        for (int row = 0; row < m; row++) {
            int color1 = col1 % 3;
            int color2 = col2 % 3;
            
            if (color1 == color2) {
                return false;
            }
            
            col1 /= 3;
            col2 /= 3;
        }
        return true;
    }
}
