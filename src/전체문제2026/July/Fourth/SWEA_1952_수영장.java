package 전체문제2026.July.Fourth;
import java.util.*;
import java.io.*;
public class SWEA_1952_수영장 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int[] price = new int[4];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<4;i++) price[i] = Integer.parseInt(st.nextToken());
            int[]dp = new int[13];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<=12;i++){
                int num = Integer.parseInt(st.nextToken());
                //1일 vs 한달
                dp[i] = Math.min((num*price[0]),price[1]) + dp[i-1];
                if(i<=3){
                    dp[i] = Math.min(dp[i],price[2]);
                }else{
                    dp[i] = Math.min(dp[i],dp[i-3]+price[2]);
                }
            }
            int answer = Math.min(dp[12],price[3]);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
