package 전체문제2026.April.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_1913_달팽이_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int G = Integer.parseInt(br.readLine());
        int[][]move = {{1,0},{0,1},{-1,0},{0,-1}};
        int[][]map = new int[N][N];
        int node = N*N;
        int i = -1; int j = 0; int d = 0;
        int ai = 0; int aj = 0;
        while(0<node){
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(ni<0||nj<0||N-1<ni||N-1<nj){
                d = (d+1)%4;
                continue;
            }
            if(map[ni][nj]!=0){
                d = (d+1)%4;
                continue;
            }
            map[ni][nj] = node;
            i = ni; j = nj;
            if(node==G){
                ai = (i+1); aj = (j+1);
            }
            node--;
        }
        StringBuilder sb = new StringBuilder();
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                sb.append(map[y][x]+" ");
            }
            sb.append("\n");
        }
        sb.append(ai+" "+aj);
        System.out.println(sb.toString());
    }
}
