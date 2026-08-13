package 전체문제2026.July.August.Ninth;

import java.util.*;
import java.io.*;
public class SWEA_1247_최적경로_D5 {
    static int N;
    static boolean[]visited;
    static int[]home;
    static int[][]customer;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            int si = Integer.parseInt(st.nextToken());
            int sj = Integer.parseInt(st.nextToken());
            customer = new int[N][2];
            answer = Integer.MAX_VALUE;
            home = new int[2];
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            for(int i=0;i<N;i++){
                customer[i][0] = Integer.parseInt(st.nextToken());
                customer[i][1] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[N];
            dfs(si,sj,0,0);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int ci,int cj,int depth,int sum){
        if(answer<=sum) return;
        if(depth==N){
            sum += Math.abs(ci-home[0]) + Math.abs(cj-home[1]);
            answer = Math.min(answer,sum);
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                int newSum = sum + Math.abs(ci-customer[i][0]) + Math.abs(cj-customer[i][1]);
                dfs(customer[i][0],customer[i][1],depth+1,newSum);
                visited[i] = false;
            }
        }
    }
}
