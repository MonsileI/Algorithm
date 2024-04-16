package 전체문제.fifth_month_2023_04.tenth_2024_04_16;

import java.util.*;
import java.io.*;
public class BJ_16500_문자열판별_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        int M = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i=0;i<M;i++){
            String tmp = br.readLine();
            if(str.contains(tmp)) set.add(tmp);
        }
        int[]dp = new int[N];
        for(int i= N;-1<i;i--){
            for(int j=i+1;j<N;j++){
                if(dp[j]==1 && set.contains(str.substring(i,j))){
                    dp[i] = 1;
                }
            }
            if(set.contains(str.substring(i))) dp[i] = 1;
        }
        System.out.println(dp[0]);
    }
}
