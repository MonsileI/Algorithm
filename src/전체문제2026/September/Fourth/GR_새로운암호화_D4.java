package 전체문제2026.September.Fourth;

import java.util.*;
import java.io.*;
public class GR_새로운암호화_D4 {

    static long xor(long n) {
        if (n < 0) return 0;

        switch ((int)(n % 4)) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            default: return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(xor(B) ^ xor(A - 1));
    }
}