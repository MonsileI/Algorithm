package 전체문제2026.March.First;

import java.util.*;
import java.io.*;
public class BJ_14620_꽃길_Silver_2 {
    static int N;
    static int[][]map;
    static int[][]dir = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
    static int answer;
    static boolean[][]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;
        dfs(0,0);
        System.out.println(answer);
    }
    static void dfs(int sum,int depth){
        if(answer<=sum) return;
        if(depth==3){
            answer = Math.min(answer,sum);
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                boolean flag = true;
                for(int d=0;d<5;d++){
                    int ni = i + dir[d][0];
                    int nj = j + dir[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj){
                        flag = false;
                        break;
                    }
                    if(visited[ni][nj]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    int total = sum;
                    for(int d=0;d<5;d++){
                        int ni = i + dir[d][0];
                        int nj = j + dir[d][1];
                        visited[ni][nj] = true;
                        total += map[ni][nj];
                    }
                    dfs(total,depth+1);
                    for(int d=0;d<5;d++){
                        int ni = i + dir[d][0];
                        int nj = j + dir[d][1];
                        visited[ni][nj] = false;
                    }
                }
            }
        }


    }
}
