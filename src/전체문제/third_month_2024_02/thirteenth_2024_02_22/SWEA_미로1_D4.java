package 전체문제.third_month_2024_02.thirteenth_2024_02_22;

import java.util.*;
import java.io.*;
public class SWEA_미로1_D4 {
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int si,sj;
    static boolean flag;
    static boolean[][]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<11;t++){
            int tc = Integer.parseInt(br.readLine());
            map = new int[16][16];
            visited = new boolean[16][16];
            flag =false;
            for(int i=0;i<16;i++){
                String str = br.readLine();
                for(int j=0;j<16;j++){
                       map[i][j] = Integer.parseInt(str.charAt(j)+"");
                       if(map[i][j]==2){
                           si = i; sj = j;
                           map[i][j]=1;
                           visited[i][j] = true;
                       }
                }
            }
            bfs(si,sj);
            sb.append("#"+tc+" ");
            if(flag) sb.append(1+"\n");
            else sb.append(0+"\n");
        }
        System.out.println(sb.toString());
    }
    static void bfs(int si,int sj){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{si,sj});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            if(map[i][j]==3){
                flag= true;
                return;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||15<ni||15<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]!=1){
                    visited[ni][nj]=true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
}
