package 전체문제2026.April.Eighth;

import java.util.*;

public class PR_프렌즈4블록_Level_2 {

    static int N,M;
    static char[][]map;
    static int answer;
    static int[][]move = {{0,0},{0,1},{1,0},{1,1}};
    static boolean isEraze;
    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[]board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(m,n,board));
    }

    static int solution(int m, int n, String[] board) {
        answer = 0;
        N = m;
        M = n;
        map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = board[i].toCharArray();
        while(true){
            erazeBlock();
            if(!isEraze) break;
            moveBlock();
        }
        return answer;
    }
    static void erazeBlock(){
        isEraze = false;
        Queue<int[]> q= new ArrayDeque<>();
        for(int i=0;i<N-1;i++){
            for(int j=0;j<M-1;j++){
               if(map[i][j]=='X') continue;
               int cnt = 1;
               for(int d=1;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(map[ni][nj]!=map[i][j]) break;
                    cnt++;
               }
               if(cnt==4){
                    isEraze = true;
                    q.offer(new int[]{i,j});
               }
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(map[ni][nj]=='X') continue;
                cnt++;
                map[ni][nj] = 'X';
            }
        }
        answer += cnt;
    }
    static void moveBlock(){
        for(int j=0;j<M;j++){
            for(int i=N-1;-1<i;i--){
                if(map[i][j]=='X'){
                    int ci = i;
                    while(true){
                        ci--;
                        if(ci<0) break;
                        if(map[ci][j]!='X') break;
                    }
                    if(-1<ci){
                        map[i][j] = map[ci][j];
                        map[ci][j] = 'X';
                    }

                }
            }
        }
    }

}
