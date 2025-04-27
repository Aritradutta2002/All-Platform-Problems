package LeetCode;
import java.util.*;
public class LeetCode1790 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(areAlmostEqual(s, t));
    }

    static public boolean areAlmostEqual(String s1, String s2) {
       boolean isEqual = false;

       if(s1.length() != s2.length()){
           return isEqual;
       }

       if(s1.equals(s2))  return true;

        for(int i = 0; i < s1.length() - 1; i++){
            if(swap(s1, i, i + 1).equals(s2)){
                isEqual = true;
                break;
            }
        }
        return isEqual;
    }

    static String swap(String s, int i, int j) {
        char[] charArray = s.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }
}
