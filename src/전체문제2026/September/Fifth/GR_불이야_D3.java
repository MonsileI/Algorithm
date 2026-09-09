package 전체문제2026.September.Fifth;

import java.util.*;
import java.io.*;
public class GR_불이야_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][]visited = new boolean[N][M];
        char[][]map = new char[N][M];
        Queue<int[]> q= new ArrayDeque<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                char ch = str.charAt(j);
                map[i][j] = ch;
                if(ch=='&'){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int cnt = 0;
        while(true){
            boolean flag = false;
            int size = q.size();
            if(q.isEmpty()){
                cnt = -1;
                break;
            }
            for(int t=0;t<size;t++){
                int[]c = q.poll();
                int i = c[0]; int j = c[1];
                if(map[i][j]=='@'){
                    flag= true;
                    break;
                }
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                    if(visited[ni][nj]) continue;
                    if(map[ni][nj]=='#') continue;
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
            if(flag){
                cnt--;
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}