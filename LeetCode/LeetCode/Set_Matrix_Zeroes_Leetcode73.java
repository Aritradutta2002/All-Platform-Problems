package LeetCode;
import java.util.Arrays;


public class Set_Matrix_Zeroes_Leetcode73 {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix1);
        setZeroes(matrix2);
        printMatrix(matrix1);
        printMatrix(matrix2);
    }

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];
        Arrays.fill(rows, 0);
        Arrays.fill(cols, 0);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rows[i] == 1 || cols[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}