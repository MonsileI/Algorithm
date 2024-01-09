package 그래프이론.플로이드와샬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_171812_우주탐사선_Gold_3 {

    static int [][]map;
    static boolean[]visited;
    static int N;
    static int answer = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                int edge = Integer.parseInt(st.nextToken());
                map[i][j] = edge;
            }
        }
        for(int l=0;l<N;l++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j] = Math.min(map[i][j],map[i][l]+map[l][j]);
                }
            }
        }
        visited= new boolean[N];
        visited[S] = true;
        dfs(1,0,S);
        System.out.println(answer);
    }
    static void dfs(int depth,int sum,int node){

        if(sum>=answer) return;

        if(depth==N){
            answer = sum;
            return;
        }


        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1,sum+map[node][i],i);
                visited[i] = false;
            }
        }

    }
}
