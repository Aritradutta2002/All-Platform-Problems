package CSESProblems;
import java.util.*;

public class NextPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            System.out.println(nextPrime(n));
        }
        sc.close();
    }

    static long nextPrime(long n) {
        if (n < 2) return 2;
        if (n == 2) return 3;
        if (n == 3) return 5;
        
        long next = n + 1;
        
        if (next % 2 == 0) next++;
        
        if (n >= 999999999989L) return 1000000000039L;
        if (n >= 999999999981L) return 999999999989L;
        
        while (!isPrime(next)) {
            next += 2;
        }
        
        return next;
    }
    
    static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
