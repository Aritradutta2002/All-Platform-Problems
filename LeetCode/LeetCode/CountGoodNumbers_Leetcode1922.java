package LeetCode;
import java.util.*;
public class CountGoodNumbers_Leetcode1922 {
    static final long MOD = 1000000007;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(countGoodNumbers(n));
        sc.close();
    }

    public static int countGoodNumbers(long n) {
        long evenExponent = (n + 1) / 2; 
        long oddExponent = n / 2;         
        long goodCount = (fastExp(5, evenExponent, MOD) * fastExp(4, oddExponent, MOD)) % MOD;
        return (int) goodCount;
    }
    
   static long fastExp(long base, long exp, long mod) {
       long result = 1;
       base = base % mod;
       while (exp > 0) {
           if ((exp & 1) == 1) {  // checking for oddness of exp
               result = (result * base) % mod;
           }
           base = (base * base) % mod;
           exp >>= 1; // rigth shift exp by 1 bit
       }
       return result;
   }
}


/*
 *  if we want to check the evernness of a number then (exp % 2 == 0)
 *  if  we want to check the oddness of a number then (exp & 1) == 1
 */