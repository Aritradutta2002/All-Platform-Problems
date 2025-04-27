
import java.util.*;

public class RemoveAllOccurrencesOfSubstring_Leetcode1910 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String part = sc.nextLine();
        System.out.println(removeOccurrences(str, part));
    }

    static public String removeOccurrences(String s, String part) {

        StringBuilder ans = new StringBuilder();
        int n = s.length();
        int m = part.length();

        for (int i = 0; i < n; i++) {
            ans.append(s.charAt(i));
            if (ans.length() >= m) {
                String sub = ans.substring(ans.length() - m);
                if (sub.equals(part)) {
                    ans.setLength(ans.length() - m);
                }
            }
        }
        return ans.toString();
    }
}
