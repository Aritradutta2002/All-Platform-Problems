package CSESProblems_Problems;
import java.io.*;
import java.util.*;

public class BitStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long mod = 1_000_000_007;
        System.out.println(exp(2, n, mod));
    }

    public static long exp(long base, long exponent, long mod) {
        if (exponent == 0) return 1;
        long half = exp(base, exponent / 2, mod);
        if (exponent % 2 == 0) return (half * half) % mod;
        return (half * half % mod) * base % mod;
    }
}
