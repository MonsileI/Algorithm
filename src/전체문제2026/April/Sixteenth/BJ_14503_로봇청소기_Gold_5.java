package 전체문제2026.April.Sixteenth;

import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class BJ_14503_로봇청소기_Gold_5 {
    static int N,M;
    static int[][]map;
    static boolean[][]clearMap;
    static int[][]dir = {{-1,0},{0,1},{1,0},{0,-1}};
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        clearMap = new boolean[N][M];
        int ri = 0; int rj = 0; int rd = 0;
        st = new StringTokenizer(br.readLine()," ");
        ri = Integer.parseInt(st.nextToken());
        rj = Integer.parseInt(st.nextToken());
        rd = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true){
            //1번 현재 칸 청소
            clear(ri,rj);
            //청소되지 않은 빈칸이 있나 없나 체크
            boolean check = isNonClear(ri,rj);
            //2번 4칸 중 청소되지 않은 빈칸이 없는 경우
            if(!check){
                ri -= dir[rd][0];
                rj -= dir[rd][1];
                if(!checkRange(ri,rj)) break;
                if(map[ri][rj]==1) break;
            }
            //3번 4칸 중 청소되지 않은 빈칸이 있는 경우
            else{
                //반시계방향 90도 회전
                rd = (rd+3)%4; // 3->2 , 2->1 1->0 0->3
                int ni = ri + dir[rd][0];
                int nj = rj + dir[rd][1];
                if(!checkRange(ni,nj)) continue;
                if(map[ni][nj]==1) continue;
                if(!clearMap[ni][nj]) {
                    ri = ni;
                    rj = nj;
                }
            }
        }
        System.out.println(answer);
    }
    static boolean isNonClear(int i,int j){
        for(int d=0;d<4;d++){
            int ni = i + dir[d][0];
            int nj = j + dir[d][1];
            if(!checkRange(ni,nj)) continue;
            if(map[ni][nj]==1) continue;
            if(!clearMap[ni][nj]) return true;
        }
        return false;
    }
    static void clear(int i, int j){
        if(!clearMap[i][j]){
            clearMap[i][j] = true;
            answer++;
        }
    }
    static boolean checkRange(int i,int j){
        if(i<0||j<0||N-1<i||M-1<j) return false;
        return true;
    }
}
