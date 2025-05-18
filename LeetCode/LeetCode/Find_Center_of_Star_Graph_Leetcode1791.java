package LeetCode;

import java.util.*;

public class Find_Center_of_Star_Graph_Leetcode1791 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        System.out.println(findCenter(edges));
        sc.close();
    }

    public static int findCenter(int[][] edges) {
        
        int a = edges[0][0];
        int b = edges[0][1];
        int c = edges[1][0];
        int d = edges[1][1];

        if (a == c || a == d) {
            return a;
        } else {
            return b;
        }

    }
}
