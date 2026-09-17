package 전체문제2026.September.Eighth;

import java.util.*;
public class PR_피로도_Level_2 {

    static int N;
    static int[][]D;
    static boolean[]visited;
    static int answer;
    public static void main(String[] args) {
        int k = 80;
        int[][]dungeons = {{80,20}, {50,40}, {30,10}}; //필요, 소모
        System.out.println(solution(k,dungeons));
    }
    static int solution(int k, int[][] dungeons) {
        D = dungeons;
        N = dungeons.length;
        visited=  new boolean[N];
        answer = 0;
        dfs(0,k);
        return answer;
    }
    static void dfs(int depth,int power){
        answer = Math.max(answer,depth);
        if(answer==N) return;
        for(int i=0;i<N;i++){
            if(!visited[i] && D[i][0] <= power){
                visited[i] = true;
                dfs(depth+1,(power-D[i][1]));
                visited[i] = false;
            }
        }
    }
}
