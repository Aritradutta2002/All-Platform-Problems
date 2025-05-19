package LeetCode_Problems;

import java.io.*;
import java.util.*;

/**
 * LeetCode 2901: Longest Unequal Adjacent Groups Subsequence II
 * Problem: Given strings words and groups where words[i] corresponds to
 * groups[i],
 * find the longest subsequence such that adjacent words are from different
 * groups
 * and the Hamming distance between them is exactly 1.
 */
public class LongestUnequalAdjacentGroupsSubsequenceII_Leetcode2901 {

    public static void main(String[] args) {
        FastIO sc = new FastIO();
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        int m = sc.nextInt();
        String[] groups = new String[m];
        for (int i = 0; i < m; i++) {
            groups[i] = sc.next();
        }

        Map<String, Integer> groupMap = new HashMap<>();
        int[] groupIds = new int[m];
        int groupIdCounter = 0;
        for (int i = 0; i < m; i++) {
            groupMap.putIfAbsent(groups[i], groupIdCounter++);
            groupIds[i] = groupMap.get(groups[i]);
        }

        List<String> result = getWordsInLongestSubsequence(words, groupIds);
        for (String word : result) {
            System.out.println(word);
        }
    }

    public static List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLength = 1;
        int endIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] == groups[j])
                    continue;

                if (hammingDistance(words[i], words[j]) == 1 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;

                    if (dp[i] > maxLength) {
                        maxLength = dp[i];
                        endIndex = i;
                    }
                }
            }
        }

        List<String> result = new ArrayList<>();
        while (endIndex != -1) {
            result.add(0, words[endIndex]);
            endIndex = prev[endIndex];
        }

        return result;
    }

    private static int hammingDistance(String a, String b) {
        if (a.length() != b.length())
            return -1;

        int distance = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }

    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar, numChars;

        public FastIO() {
            this(System.in, System.out);
        }

        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }

        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }

        private int nextByte() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c;
            do {
                c = nextByte();
            } while (c <= '\n');
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > '\n');
            return res.toString();
        }

        public String next() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > ' ');
            return res.toString();
        }

        public int nextInt() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }

        public long nextLong() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            long sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
