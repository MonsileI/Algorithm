package 전체문제.sixth_month_2024_05.seventeenth_2024_05_27;

import java.util.*;
import java.io.*;
public class BJ_14503_로봇청소기_Gold_5 {
    static int N,M;
    static int[][]map;
    static int ri,rj,rd;
    static int[][]move=  {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        ri = Integer.parseInt(st.nextToken()); rj = Integer.parseInt(st.nextToken()); rd = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        while(true){
            if(map[ri][rj]==0){
                map[ri][rj] = 2;
                ans++;
                continue;
            }
            boolean flag = false;
            for(int d=0;d<4;d++){
                int ni = ri + move[d][0];
                int nj = rj + move[d][1];
                if(map[ni][nj]==1 || map[ni][nj]==2) continue;
                flag=  true;
                break;
            }
            if(flag){
                rd = (rd+3)%4;
                int ni = ri + move[rd][0];
                int nj = rj + move[rd][1];
                if(map[ni][nj]==0){
                    ri = ni;
                    rj = nj;
                }
            }
            else {
                int ni = ri - move[rd][0];
                int nj = rj - move[rd][1];
                if (map[ni][nj] == 1) break;
                ri = ni;
                rj = nj;
            }
        }
        System.out.println(ans);
    }
}
