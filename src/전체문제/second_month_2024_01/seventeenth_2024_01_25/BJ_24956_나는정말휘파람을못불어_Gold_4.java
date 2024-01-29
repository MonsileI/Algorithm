package 전체문제.second_month_2024_01.seventeenth_2024_01_25;

import java.util.*;
import java.io.*;
public class BJ_24956_나는정말휘파람을못불어_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[]arr = br.readLine().toCharArray();
        int cnt = 0;
        for(int i=0;i<N;i++) if(arr[i]=='E') cnt++;
        int[]dp = new int[cnt+1];
        int mod = 1000000007;
        if(cnt>2){
            dp[2] = 1;
            int num = 3;
            for(int i =3;i<cnt+1;i++) {
                dp[i] = (dp[i-1]%mod) + (num%mod);
                num *= 2;
                num++;
            }
        }
        System.out.println(Arrays.toString(dp));

    }
}
