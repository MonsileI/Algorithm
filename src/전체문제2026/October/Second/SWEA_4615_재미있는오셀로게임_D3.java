package 전체문제2026.October.Second;

import java.util.*;
import java.io.*;
public class SWEA_4615_재미있는오셀로게임_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M =  Integer.parseInt(st.nextToken());
            int[][]map = new int[N+1][N+1];
            int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
            int[][]crossMove = {{-1,1},{1,1},{1,-1},{-1,-1}};
            //1이면 흑, 2면 백
            map[N/2][N/2] = 2; map[N/2][(N/2) + 1] = 1;
            map[(N/2)+1][N/2] = 1; map[(N/2)+1][(N/2)+1] = 2;
            for(int c=0;c<M;c++){

                st = new StringTokenizer(br.readLine()," ");
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int dol = Integer.parseInt(st.nextToken());
                map[i][j] = dol;
                //체크로직 -> 체크 후 변환
                for(int d=0;d<4;d++){
                   int ni = i + move[d][0];
                   int nj = j + move[d][1];
                   int gi = -1;
                   int gj = -1;
                   while(true){
                       if(ni<1||nj<1||N<ni||N<nj) break;
                       if(map[ni][nj]==0) break;
                       if(map[ni][nj]==dol) {
                           gi = ni;
                           gj = nj;
                           break;
                       }
                       ni += move[d][0];
                       nj += move[d][1];
                   }
                   if(gi !=-1 ){
                       ni = i + move[d][0];
                       nj = j + move[d][1];
                       while(true){
                           map[ni][nj] = dol;
                           if(ni==gi && nj==gj) break;
                           ni += move[d][0];
                           nj += move[d][1];
                       }
                   }

                    ni = i + crossMove[d][0];
                    nj = j + crossMove[d][1];
                    gi = -1;
                    gj = -1;
                    while(true){
                        if(ni<1||nj<1||N<ni||N<nj) break;
                        if(map[ni][nj]==0) break;
                        if(map[ni][nj]==dol) {
                            gi = ni;
                            gj = nj;
                            break;
                        }
                        ni += crossMove[d][0];
                        nj += crossMove[d][1];
                    }
                    if(gi!=-1){
                        ni = i + crossMove[d][0];
                        nj = j + crossMove[d][1];
                        while(true){
                            map[ni][nj] = dol;
                            if(ni==gi && nj==gj) break;
                            ni += crossMove[d][0];
                            nj += crossMove[d][1];
                        }
                    }

                }

            }
            int black = 0; int white = 0;
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(map[i][j]==1) black++;
                    if(map[i][j]==2) white++;
                }
            }
            sb.append("#"+t+" "+black+" "+white+"\n");
        }
        System.out.println(sb.toString());
    }
}
