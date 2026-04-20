package 전체문제2026.April.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_5212_지구온난화_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][]map = new char[N][M];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        boolean[][]willBeSea = new boolean[N][M];
        int[][]move=  {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='.') continue;
                int cnt = 0;
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||M-1<nj) cnt++;
                    else if(map[ni][nj]=='.') cnt++;
                    if(3<=cnt) break;
                }
                if(3<=cnt) willBeSea[i][j] = true;
            }
        }
        int minI = N-1; int minJ = M-1;
        int maxI = 0; int maxJ = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(willBeSea[i][j]) map[i][j] = '.';
                if(map[i][j]=='X'){
                    minI = Math.min(minI,i);
                    minJ = Math.min(minJ,j);
                    maxI = Math.max(maxI,i);
                    maxJ = Math.max(maxJ,j);
                }
            }
        }
        System.out.println(minI+" "+minJ+" "+maxI+" "+maxJ);
        StringBuilder sb= new StringBuilder();
        for(int i =minI;i<=maxI;i++){
            for(int j=minJ;j<=maxJ;j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
