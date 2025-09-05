package 전체문제2025.August.First;
import java.util.*;
import java.io.*;
public class BJ_1012_유기농배추_Silver_2 {

    static int N,M;
    static int [][] map;
    static boolean [][] visited;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int cabbageCount = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            answer = 0;
            for(int c=0;c<cabbageCount;c++){
                st = new StringTokenizer(br.readLine()," ");
                int j = Integer.parseInt(st.nextToken());
                int i = Integer.parseInt(st.nextToken());
                map[i][j] = 1;
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        bfs(i,j);
                        answer++;
                    }
                }
            }
            sb.append(answer+"\n");

        }
        System.out.println(sb.toString());
    }
    static void bfs(int y,int x){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0];
            int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) {
                    continue;
                }
                if(!visited[ni][nj] && map[ni][nj]==1){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
}
