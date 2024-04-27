package 전체문제.fifth_month_2023_04.ninteenth_2024_04_27;

import java.util.*;
import java.io.*;
public class BJ_18110_solved_ac_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        int num = (int)Math.round((double)N*0.15);
        double sum  =0;
        Arrays.sort(arr);
        for(int i=num; i <N-num;i++) sum += arr[i];
        N -= (num*2);
        int ans = (int)Math.round(sum/N);
        System.out.println(ans);
    }
}
