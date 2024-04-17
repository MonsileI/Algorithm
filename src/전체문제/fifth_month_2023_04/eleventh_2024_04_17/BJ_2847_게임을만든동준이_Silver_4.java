package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_2847_게임을만든동준이_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=N-1;0<i;i--){
            if(arr[i]<=arr[i-1]){
                ans += arr[i-1] - (arr[i]-1);
                arr[i-1] = arr[i]-1;
            }
        }
        System.out.println(ans);

    }
}
