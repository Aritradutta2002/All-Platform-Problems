import java.util.*;
@SuppressWarnings("unused")

public class RemoveOutermostParentheses_Leetcode1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(removeOuterParentheses(str));
    }

    static public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth > 0) {
                    res.append(c);
                }
                depth++;
            } else if (c == ')') {
                depth--;
                if (depth > 0) {
                    res.append(c);
                }
            }
        }

        return res.toString();
    }
}