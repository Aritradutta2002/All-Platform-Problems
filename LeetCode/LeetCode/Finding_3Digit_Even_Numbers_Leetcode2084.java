package LeetCode;
import java.util.*;

public class Finding_3Digit_Even_Numbers_Leetcode2084 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] digits = new int[n];
            for (int i = 0; i < n; i++) {
                digits[i] = sc.nextInt();
            }
            int[] result1 = findEvenNumbers(digits);
            int[] result2 = {2, 1, 3, 0};
            int[] result3 = {2, 2, 8, 8, 2};
            
            System.out.println("Result: " + Arrays.toString(findEvenNumbers(result1)));
            System.out.println("Result: " + Arrays.toString(findEvenNumbers(result2)));
            System.out.println("Result: " + Arrays.toString(findEvenNumbers(result3)));
        }
    }

    public static int[] findEvenNumbers(int[] digits) {
        List<Integer> evenNumbers = new ArrayList<>();
        
        int n = digits.length;
        if (n < 3) {
            return new int[0]; 
        }

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue; 
                }
                
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) {
                        continue; 
                    }
                    if (digits[k] % 2 != 0) {
                        continue;
                    }
                    int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                    evenNumbers.add(number);
                }
            }
        }

        return evenNumbers.stream()
                .distinct()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
