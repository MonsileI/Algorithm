package 전체문제.second_month_2024_01.fourteenth_2024_01_22;
import java.util.*;
import java.io.*;
public class BJ_2662_기업투자_Gold_2 {
    static int[]path;
    static int[][]invest;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]info = new int[N+1][M+1];
        int[][]dp = new int[N+1][M+1];
        invest = new int[N+1][M+1];
        path = new int[M+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            st.nextToken();
            for(int j=1;j<M+1;j++){
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<M+1;i++){
            for(int j=0;j<N+1;j++){
                for(int k=N-j;-1<k;k--){
                    if(dp[j+k][i] < dp[k][i-1] + info[j][i]){
                        dp[j+k][i] = dp[k][i-1] + info[j][i];
                        invest[j+k][i] = j;
                    }
                }
            }
        }
        getPath(N,M);
        StringBuilder sb= new StringBuilder();
        sb.append(dp[N][M]+"\n");
        for(int i=1;i<M+1;i++)sb.append(path[i]+" ");
        System.out.println(sb.toString());

    }
    static void getPath(int N,int M){
        if(M==0) return ;
        path[M] = invest[N][M];
        getPath(N-path[M],M-1);
    }
}
