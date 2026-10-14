package 전체문제2026.October.Sixth;

import java.util.*;
import java.io.*;
public class SWEA_8016_홀수피라미드_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            long N = Long.parseLong(br.readLine());
            long left = 2; long right = 6;
            if(N==1){
                left = 1; right = 1;
            }else {
                left = calcLeft(N);
                right = calcRight(N);
            }
            sb.append("#"+t+" "+left+" "+right+"\n");
        }
        System.out.println(sb.toString());
    }
    static long calcLeft(long N) {
        return 2 * N * N - 4 * N + 3;
    }
    static long calcRight(long N) {
        return 2 * N * N - 1;
    }
}
