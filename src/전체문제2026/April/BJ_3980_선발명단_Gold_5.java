package 전체문제2026.April;

import java.util.*;
import java.io.*;
public class BJ_3980_선발명단_Gold_5 {
    static int N;
    static int answer;
    static int[][]ability;
    static boolean[]visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        StringTokenizer st  =null;
        int TC = Integer.parseInt(br.readLine());
        N = 11;
        while(0<TC){
            answer = 0;
            visited = new boolean[N];
            ability = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++) {
                    ability[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0,0);
            sb.append(answer+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
    static void dfs(int depth, int sum){
        if(depth==N){
            answer = Math.max(answer,sum);
            return;
        }

        for(int i=0;i<11;i++){
            if(!visited[i]&&ability[depth][i]!=0){
                visited[i] = true;
                dfs(depth+1,sum+ability[depth][i]);
                visited[i] = false;
            }
        }
    }
}
