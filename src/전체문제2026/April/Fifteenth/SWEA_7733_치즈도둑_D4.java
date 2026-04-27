package 전체문제2026.April.Fifteenth;

import java.util.*;
import java.io.*;
public class SWEA_7733_치즈도둑_D4 {
    static int N;
    static int[][]map;
    static boolean[][]visited;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            int max = 1;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int d=2;d<=100;d++){
                boolean flag = false;
                visited = new boolean[N][N];
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        map[i][j]--;
                        if(map[i][j]<0) map[i][j] = 0;
                    }
                }
                int tmp = 0;
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(map[i][j]==0) continue;
                        if(!visited[i][j]){
                            flag = true;
                            visited[i][j] = true;
                            bfs(i,j);
                            tmp++;
                        }
                    }
                }
                if(!flag) break;
                if(max<tmp){
                    max = tmp;
                }
            }
            sb.append("#"+t+" "+max+"\n");

        }
        System.out.println(sb.toString());
    }
    static void bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i =  c[0]; int j  =c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(map[ni][nj]==0) continue;
                if(visited[ni][nj]) continue;
                visited[ni][nj] = true;
                q.offer(new int[]{ni,nj});
            }
        }
    }
}
