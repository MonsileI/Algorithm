package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ_10026_적록색약_Gold_5 {
    static int N;
    static char[][]map;
    static boolean[][]visited;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //빨강 초록 같음
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        int f = 0;
        visited=  new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    bfs(i,j,map[i][j],false);
                    f++;
                }
            }
        }
        visited = new boolean[N][N];
        int s = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    bfs(i,j,map[i][j],true);
                    s++;
                }
            }
        }
        System.out.println(f+" "+s);
    }
    static void bfs(int y,int x,char v,boolean check){
        Queue<int[]> q= new ArrayDeque<>();
        visited[y][x] = true;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]){
                    if(map[ni][nj]==v) {
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                    }else if(check && map[ni][nj]!='B' && v!='B'){
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                    }
                }
            }
        }
    }
}
