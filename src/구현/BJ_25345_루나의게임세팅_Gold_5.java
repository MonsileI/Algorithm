package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BJ_25345_루나의게임세팅_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]arr =new int[N];
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int mod = 1000000007;
        int[][]memo = new int[2001][2001];
        for(int i=0;i<N+1;i++){
            memo[i][0] = 1;
            for(int j=1;j<i+1;j++){
                memo[i][j] = (memo[i-1][j-1]+memo[i-1][j]) % mod;
            }
        }
        int comb = memo[N][M];
        for(int i=1;i<M;i++) comb = comb * 2 % mod;
        System.out.println(comb);
    }
}
