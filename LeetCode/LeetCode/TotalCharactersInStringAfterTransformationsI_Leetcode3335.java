package LeetCode;
import java.util.*;
@SuppressWarnings("unused")

public class TotalCharactersInStringAfterTransformationsI_Leetcode3335{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();

        System.out.println(lengthAfterTransformations(str, k));
        System.out.println(lengthAfterTransformations("abcyy", 2)); // output -> 7
        System.out.println(lengthAfterTransformations("azbk", 1)); // output -> 5

    }

    public static int lengthAfterTransformations(String s, int t) {
        int n = s.length();

        for(char ch : s.toCharArray()){
            
        }




        return 0;
    }
}