package 전체문제.fifth_month_2023_04.sitxth_2024_04_09;
import java.util.*;
import java.io.*;
public class BJ_12869_뮤탈리스크_Gold_4 {
    static int N;
    static int [][] attack = {{-9,-3,-1},{-9,-1,-3},{-3,-9,-1},{-3,-1,-9},{-1,-3,-9},{-1,-9,-3}};

    static int[][][]dp;
    static int answer = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[61][61][61];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[3];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        dfs(arr,0);
        System.out.println(answer);
    }
    static void dfs(int []arr,int cnt){
        if(answer<=cnt) return;
        int f=arr[0]; int s=arr[1]; int t=arr[2];
        if(dp[f][s][t]!=0 && dp[f][s][t]<=cnt) return;
        dp[f][s][t] = cnt;
        if(f==0&&s==0&&t==0){
            answer = Math.min(answer,cnt);
            return;
        }
        for(int i=0;i<6;i++){
            int nf = Math.max(f+attack[i][0],0);
            int ns = Math.max(s+attack[i][1],0);
            int nt = Math.max(t+attack[i][2],0);
            dfs(new int[]{nf,ns,nt},cnt+1);
        }
    }
}
