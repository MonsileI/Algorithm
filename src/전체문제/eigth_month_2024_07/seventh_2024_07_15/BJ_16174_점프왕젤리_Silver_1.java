package 전체문제.eigth_month_2024_07.seventh_2024_07_15;

import java.util.*;
import java.io.*;
public class BJ_16174_점프왕젤리_Silver_1 {
    static int N;
    static int[][]map;
    static int [][]move = {{0,1},{1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }
    static String bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        boolean[][]visited=  new boolean[N][N];
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] c = q.poll();
            int i = c[0]; int j =c[1]; int v = map[i][j];
            if(i==N-1 && j==N-1) return "HaruHaru";
            for(int d=0;d<2;d++){
                int ni = i + (move[d][0]) * v;
                int nj = j + (move[d][1]) * v;
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return "Hing";
    }
}
