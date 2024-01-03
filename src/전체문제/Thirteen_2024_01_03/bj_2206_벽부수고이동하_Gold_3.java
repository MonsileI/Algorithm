package 전체문제.Thirteen_2024_01_03;
import java.util.*;
import java.io.*;
public class bj_2206_벽부수고이동하_Gold_3 {
    static int N,M;
    static char[][]map;
    static boolean[][][]visited;
    static int answer = 987654321;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        bfs();
        System.out.println(answer==987654321 ? -1 : answer);
    }
    static void bfs(){
        visited=  new boolean[N][M][2];
        Queue<int[]> q= new ArrayDeque<>();
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        q.offer(new int[]{0,0,1,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];int cnt = c[2]; int wall = c[3];
            if(i==N-1&&j==M-1) {
                answer = Math.min(answer,cnt);
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;

                if(wall==0){
                    if(!visited[ni][nj][0] && map[ni][nj]=='0'){
                        visited[ni][nj][0] = true;
                        q.offer(new int[]{ni,nj,cnt+1,0});
                    }
                    if(!visited[ni][nj][1] && map[ni][nj]=='1'){
                        visited[ni][nj][1] = true;
                        q.offer(new int[]{ni,nj,cnt+1,1});
                    }
                }else{
                    if(!visited[ni][nj][1] && map[ni][nj]=='0'){
                        visited[ni][nj][1] = true;
                        q.offer(new int[]{ni,nj,cnt+1,1});
                    }
                }
            }
        }
    }
}
