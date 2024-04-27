package 전체문제.fifth_month_2023_04.ninteenth_2024_04_27;

import java.util.*;
import java.io.*;
public class BJ_2839_설탕배달_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        while(0<N){
            if(N%5==0){
                ans += (N/5);
                N = 0;
            }
            else{
                N -= 3;
                ans++;
            }
        }
        if(N!=0) System.out.println(-1);
        else System.out.println(ans);
    }
}
