package 전체문제.seven_month_2024_06.sixteenth_2024_06_27;

import java.util.*;
import java.io.*;
public class GR_ab를bba로_Level_3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]dp = new int[1000001];
        //a의 개수가 2개
        int module = 1000000007;
        for(int i=1;i<1000001;i++) dp[i] = (dp[i-1] * 2 + 1 ) % module;
        String str = br.readLine();
        int N = str.length();
        int cnt = 0;
        int ans = 0;
        for(int i=0;i<N;i++){
            char ch = str.charAt(i);
            if(ch=='a') cnt++;
            else{
                ans =  (ans+dp[cnt]) % module;
            }
        }
        System.out.println(ans);
    }
}
