package 전체문제2026.March.Eighth;

import java.util.*;
import java.io.*;
public class BJ_1996_지뢰찾기_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][]map = new char[N][N];
        int[][]answer = new int[N][N];
        int[][]move = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]!='.'){
                    int num = map[i][j] - '0';
                    answer[i][j] = -1;
                    for(int d=0;d<8;d++){
                        int ni = i + move[d][0];
                        int nj = j + move[d][1];
                        if(ni<0||nj<0||N-1<ni||N-1<nj) continue; //범위
                        if(answer[ni][nj]==-1) continue; //지뢰칸
                        answer[ni][nj] += num;
                    }

                }
            }
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(answer[i][j]==-1) sb.append("*");
                else if(9<answer[i][j]) sb.append('M');
                else sb.append(answer[i][j]);
            }
            if(i==N-1) break;
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
