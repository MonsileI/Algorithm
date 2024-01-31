package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16927_TwoDots_Gold_4 {
    static int N,M;
    static char[][]map;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int[][]check = {{-1,0},{0,-1},{-1,-1}};
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        OuterLoop:
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int cnt = 0;
                for(int d=0;d<3;d++){
                    int ni = i + check[d][0];
                    int nj = j + check[d][1];
                    if(ni<0||nj<0) break;
                    if(map[ni][nj]!=map[i][j]) break;
                    cnt++;
                }
                if(cnt==3){
                    flag= true;
                    break OuterLoop;
                }
            }
        }
        if(flag){
            System.out.println("Yes");
        }else{
            visited = new boolean[N][M];
            OuterLoop:
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j]){
                        visited[i][j] = true;
                        for(int d=0;d<4;d++){
                            int ni = i + move[d][0];
                            int nj = j + move[d][1];
                            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                            if(!visited[ni][nj]&&map[ni][nj]==map[i][j]){
                                dfs(ni,nj,map[i][j],i,j);
                                break;
                            }
                        }
                    }
                    if(flag) break OuterLoop;

                }
            }
        System.out.println(flag ? "Yes" : "No");
        }
    }
    static void dfs(int i,int j,char v,int bi,int bj){
        visited[i][j] = true;
        for(int d=0;d<4;d++){
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
            if(visited[ni][nj]&&map[ni][nj]==v){
                if(ni!=bi || nj !=bj){
                    flag = true;
                    return;
                }
            }
            if(!visited[ni][nj]&&map[ni][nj]==v){
                dfs(ni,nj,v,i,j);
            }
        }
    }
}
