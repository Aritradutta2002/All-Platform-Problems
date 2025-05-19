package LeetCode;

import java.io.*;
import java.util.*;

public class TypeOfTriangle {
    public static void main(String[] args) {
        FastIO sc = new FastIO();
        int n = sc.nextInt();
        int[] nums = sc.readIntArray(n);
        System.out.println(typeOfTriangle(nums));
    }

    public static String typeOfTriangle(int[] nums) {
        if (nums.length != 3) {
            throw new IllegalArgumentException("Input array must have exactly 3 elements");
        }

        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Side lengths must be positive");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Not a triangle";
        }

        if (a == b && b == c) {
            return "Equilateral";
        } else if (a == b || b == c || a == c) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }

    static class FastIO extends PrintWriter{
        private InputStream stream;private byte[]buf=new byte[1<<16];
        private int curChar,numChars;public FastIO(){this(System.in,System.out);}
        public FastIO(InputStream i,OutputStream o){super(o);stream=i;}
        public FastIO(String i,String o)throws IOException{super(new FileWriter(o));stream=new FileInputStream(i);}
        private int nextByte(){if(numChars==-1)throw new InputMismatchException();if(curChar>=numChars){curChar=0;try{numChars=stream.read(buf);}catch(IOException e){throw new InputMismatchException();}if(numChars==-1)return -1;}return buf[curChar++];}
        public String nextLine(){int c;do{c=nextByte();}while(c<='\n');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>'\n');return res.toString();}
        public String next(){int c;do{c=nextByte();}while(c<=' ');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>' ');return res.toString();}
        public int nextInt(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}int res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res*sgn;}
        public long nextLong(){int c;do{c=nextByte();}while(c<=' ');long sgn=1;if(c=='-'){sgn=-1;c=nextByte();}long res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res*sgn;}
        public double nextDouble(){return Double.parseDouble(next());}
        public int[] readIntArray(int n){int[]arr=new int[n];for(int i=0;i<n;i++){arr[i]=nextInt();}return arr;}
        public void printArray(int[]arr){for(int i=0;i<arr.length;i++){System.out.print(arr[i]+" ");}}
    }
}