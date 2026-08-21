package 전체문제2026.July.August.Fourteenth;

import java.util.*;
import java.io.*;
public class GR_도시이동경로경우의수_D3 {

    static int MOD = 1000000007;
    static long pow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp /= 2;
        }

        return result;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if (N <= 2) {
            System.out.println(1);
        } else {
            System.out.println(pow(2, N - 2));
        }
    }
}
