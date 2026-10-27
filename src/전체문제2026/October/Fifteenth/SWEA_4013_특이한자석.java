package 전체문제2026.October.Fifteenth;

import java.util.*;
import java.io.*;
public class SWEA_4013_특이한자석 {
    static int N = 4;
    static int M = 8;
    static int [][] top;
    static boolean[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int Q = Integer.parseInt(br.readLine());
            top = new int[N][M];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<M;j++){
                    top[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<Q;i++){
                visited=  new boolean[4];
                st = new StringTokenizer(br.readLine()," ");
                int node = Integer.parseInt(st.nextToken())-1;
                int turn = Integer.parseInt(st.nextToken());
                dfs(node,turn);
            }
            int answer = 0;
            //1 2 4 8
            for(int i=0;i<N;i++){
                if(top[i][0]==1){
                    answer += (int)Math.pow(2,i);
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int node,int turn){
        visited[node] = true;
        int otherTurn = turn * -1;
        //왼쪽
        if(0<node){
            if(top[node][6]!=top[node-1][2] && !visited[node-1]){
                dfs(node-1,otherTurn);
            }
        }
        //오른쪽
        if(node<N-1){
            if(top[node][2]!=top[node+1][6] && !visited[node+1]){
                dfs(node+1,otherTurn);
            }
        }

        //시계방향
        if(turn==1){
            // 0 -> 1
            int first = top[node][M-1];
            //i = i-1 N-1 1<i
            for(int i=M-1;0<i;i--){
                top[node][i] = top[node][i-1];
            }
            top[node][0] = first;
        }
        //반시계방향
        if(turn==-1){
            // 1 -> 0
            int first = top[node][0];
            for(int i=0;i<M-1;i++){
                top[node][i] = top[node][i+1];
            }
            top[node][M-1] = first;
        }

    }
}
