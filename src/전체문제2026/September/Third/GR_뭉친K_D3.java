package 전체문제2026.September.Third;

import java.util.*;
import java.io.*;
public class GR_뭉친K_D3 {
    static int N;
    static int [][]map;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        map  =new int[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        num = map[x][y];
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]!=num) continue;
                if(visited[i][j]) continue;
                visited[i][j] = true;
                answer = Math.max(answer,bfs(i,j));
            }
        }
        System.out.println(answer);
    }
    static int bfs(int y,int x){
        Queue<int[]> q =new ArrayDeque<>();
        int cnt = 1;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj]!=num) continue;
                visited[ni][nj] = true;
                cnt++;
                q.offer(new int[]{ni,nj});
            }
        }
        return cnt;
    }
}
