package 전체문제2026.October.Fifth;

import java.util.*;
import java.io.*;
public class SWEA_1868_파핑파핑지뢰찾기_D4 {
    static boolean [][] visited;
    static int N;
    static char[][]map;
    static int[][]dir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            map = new char[N][N];
            Queue<int[]> q= new ArrayDeque<>();
            for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
            //0이면 넣어주고, 아니면 빼주고
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]=='.') {
                        boolean flag = true;
                        for(int d=0;d<8;d++){
                            int ni = i + dir[d][0];
                            int nj = j + dir[d][1];
                            if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                            if(map[ni][nj]=='*'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag) {
                            map[i][j] = '0';
                        }
                    }
                }
            }
            int answer = 0;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]=='0' && !visited[i][j]){
                        answer++;
                        visited[i][j] = true;
                        bfs(i,j);
                    }
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]=='.') answer++;
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void bfs(int y, int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            //색칠하기
            for(int d=0;d<8;d++){
                int ni = i + dir[d][0];
                int nj = j + dir[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                //색칠하기
                if(map[ni][nj]=='.'){
                    map[ni][nj] = 'c';
                }
                //퍼뜨리기
                if(!visited[ni][nj]&& map[ni][nj]=='0'){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
            
        }
    }
}
