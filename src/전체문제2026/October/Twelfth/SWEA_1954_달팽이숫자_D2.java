package 전체문제2026.October.Twelfth;

import java.util.*;
import java.io.*;
public class SWEA_1954_달팽이숫자_D2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int[][]move = {{0,1},{1,0},{0,-1},{-1,0}};//1 -> 2 -> 3 -> 0
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[][]map = new int[N][N];
            int num = 1;
            int goal = N*N;
            int i =0; int j =0;
            int d = 0;
            map[i][j] = num;
            while(num<goal){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) {
                    d = (d+1)%4;
                    continue;
                }
                if(map[ni][nj]!=0){
                    d = (d+1)%4;
                    continue;
                }
                map[ni][nj] = ++num;
                i = ni; j = nj;
            }
            sb.append("#"+t+"\n");
            for(int y=0;y<N;y++){
                for(int x=0;x<N;x++){
                    sb.append(map[y][x]);
                    if(x==N-1) break;
                    sb.append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
