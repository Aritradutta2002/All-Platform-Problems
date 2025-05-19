package LeetCode_Problems;
import java.util.*;
public class LargestOddNumInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(largeOddNum(str));

    }

      public static String largeOddNum(String s) {
        String str = "";

        for(int i = 0; i < s.length(); i++) {
            for(int j = s.length(); j >= 0; j--) {
                if(s.charAt(i) == '0') {
                    continue;
                }
                
                str = s.substring(i, j);
                if(Integer.parseInt(str) % 2 != 0) {
                    return str;
                }
            }

        }

        return "";
    }
}