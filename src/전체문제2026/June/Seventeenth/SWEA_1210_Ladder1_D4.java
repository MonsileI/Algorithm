package 전체문제2026.June.Seventeenth;

import java.util.*;
import java.io.*;
public class SWEA_1210_Ladder1_D4 {
    static int N,M;
    static int[][]map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int tc = -1;
        N = 100; M = 100;

        int[][]move = {{1,0},{0,-1},{0,1}}; //아래 왼 오
        while(true) {
            tc = Integer.parseInt(br.readLine());
            map = new int[N][M];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<M;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            OuterLoop:
            for(int j=0;j<M;j++){
                if(map[0][j]==0) continue;
                boolean flag = false;
                int d = 0; //처음 아래 방향
                int i = 0;
                int tj = j;
                while(true){
                    //아래로 가고 있을 경우, 왼쪽 혹은 오른쪽이 1이면 그쪽으로 방향 전환
                    int tmpI = 0;
                    int tmpJ = 0;
                    boolean tmpFlag = false;
                    if(d==0){
                        for(int dir=1;dir<3;dir++){
                            tmpI = i + move[dir][0];
                            tmpJ = tj + move[dir][1];
                            if(canMove(tmpI,tmpJ)) {
                                i = tmpI; tj = tmpJ; d = dir;
                                tmpFlag = true;
                                break;
                            }
                        }
                    //왼쪽이나 오른쪽으로 가고 있을 경우, 그 앞이 0이면 아래로 전환
                    }else{
                        tmpI = i + move[d][0];
                        tmpJ = tj + move[d][1];
                        if(!canMove(tmpI,tmpJ)){
                            d = 0;
                        }
                    }
                    if(!tmpFlag){
                        i += move[d][0];
                        tj += move[d][1];
                    }
                    if(i==N) break;
                    if(map[i][tj]==2){
                        answer = j;
                        break OuterLoop;
                    }

                }
            }
            sb.append("#"+tc+" "+answer+"\n");
            if(tc==10) break;
        }
        System.out.println(sb.toString());
    }
    static boolean canMove(int i,int j){
        if(i<0||j<0||N-1<i||M-1<j) return false;
        if(map[i][j]==0) return false;
        return true;
    }
}
