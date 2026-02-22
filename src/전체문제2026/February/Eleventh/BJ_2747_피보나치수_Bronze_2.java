package 전체문제2026.February.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_2747_피보나치수_Bronze_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==1) {
            System.out.println(1);
            return;
        }
        int[]arr = new int[N+1];
        arr[1] = 1;
        arr[2] = 1;
        for(int i=3;i<N+1;i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[N]);
    }
}
