package 전체문제2026.June.Third;

import java.util.*;
public class PR_2차원동전뒤집기_Level_3 {
    public static void main(String[] args) {
        int[][] beginning = {{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        int[][]target = {{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
        System.out.println(solution(beginning,target));
    }
    static int answer;
    static boolean[][]map;
    static boolean[][]origin;
    static int N,M;
    static  int solution(int[][] beginning, int[][] target) {
        answer = Integer.MAX_VALUE;
        N  = beginning.length;
        M = beginning[0].length;
        map = new boolean[N][M];
        origin = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(beginning[i][j]==1){
                    map[i][j] = true;
                }
                if(target[i][j]==1){
                    origin[i][j] = true;
                }

            }
        }
        dfs(0,0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    static void change(int i){
        for(int j=0;j<M;j++){
            map[i][j] = !map[i][j];
        }
    }
    static int check(int j){
        //전부 같은 경우 0
        //전부 다른 경우 1
        //아예 이상한 경우 -1
        int cnt = 0;
        boolean flag = true;
        if(map[0][j] != origin[0][j]) flag = false;

        for(int i=1;i<N;i++){
            if(flag){
                if(map[i][j]!=origin[i][j]){
                    cnt = -1;
                    break;
                }
            }else{
                if(map[i][j]==origin[i][j]){
                    cnt = -1;
                    break;
                }
            }
        }
        if(cnt!=-1) {
            if(!flag) cnt = 1;
        }
        return cnt;
    }
    static void dfs(int i,int cnt){
        if(i==N){
            boolean flag = true;
            for(int j=0;j<M;j++){
                int c = check(j);
                if(c==-1){
                    flag = false;
                    break;
                }
                cnt += c;
            }
            if(flag){
                answer = Math.min(answer,cnt);
            }
            return;
        }
         change(i);
        dfs(i+1,cnt+1);
        change(i);
        dfs(i+1,cnt);
    }
}
