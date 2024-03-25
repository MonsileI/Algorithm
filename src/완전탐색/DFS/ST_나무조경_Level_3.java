package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ST_나무조경_Level_3 {
    static int N;
    static int[][]map;
    static int answer;
    static boolean[][]visited;
    static int [][]move = {{0,1},{1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st= null;
        map = new int[N][N];
        visited= new boolean[N][N];
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(N==2) dfs(0,0,2);
        else dfs(0,0,4);
        System.out.println(answer);
    }
    static void dfs(int sum,int depth,int Goal){
        if(depth==Goal){
            answer = Math.max(answer,sum);
            return;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]) continue;
                for(int d=0;d<2;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                    if(visited[ni][nj]) continue;
                    visited[i][j] = true;
                    visited[ni][nj] = true;
                    dfs(sum+map[i][j]+map[ni][nj],depth+1,Goal);
                    visited[i][j] = false;
                    visited[ni][nj] = false;
                }
            }
        }

    }
}
