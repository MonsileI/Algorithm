package 전체문제2026.May.Fourth;

import java.util.*;
import java.io.*;
public class SWEA_24001_로봇언어_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(0<TC){
            String str = br.readLine();
            int N = str.length();
            boolean[][]dp = new boolean[N+1][101];
            int answer = 0;
            //처음 위치는 50
            dp[0][50] = true;
            for(int i=1;i<N+1;i++){
                char ch = str.charAt(i-1);
                for(int j=0;j<101;j++){
                    if(dp[i-1][j]){
                        if(ch=='L' && j!=0){
                            dp[i][j-1] = true;
                            answer = Math.max(answer,Math.abs(50-(j-1)));
                        }else if(ch=='R'&& j!=100){
                            dp[i][j+1] = true;
                            answer = Math.max(answer,Math.abs(50-(j+1)));
                        }else{
                            if(j!=0) dp[i][j-1] = true;
                            if(j!=100) dp[i][j+1] = true;
                            answer = Math.max(answer,Math.abs(50-(j-1)));
                            answer = Math.max(answer,Math.abs(50-(j+1)));
                        }
                    }
                }
            }
            sb.append(answer+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
