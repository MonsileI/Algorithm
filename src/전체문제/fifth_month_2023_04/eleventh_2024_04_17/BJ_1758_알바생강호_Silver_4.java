package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_1758_알바생강호_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr= new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        long ans  =0;
        int minus = 1;
        for(int i=N-1;-1<i;i--){
            int num = arr[i] - (minus-1);
            num = Math.max(num,0);
            ans += num;
            minus++;
        }
        System.out.println(ans);
    }
}
