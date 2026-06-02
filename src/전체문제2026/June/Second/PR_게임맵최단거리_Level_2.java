package 전체문제2026.June.Second;

import java.util.*;

public class PR_게임맵최단거리_Level_2 {
    public static void main(String[] args) {
        int[][]maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }

    static int solution(int[][] maps) {
        int answer = -1;
        int N = maps.length;
        int M = maps[0].length;
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][]visited = new boolean[N][M];
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{0,0,1});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            if(i==N-1 && j==M-1){
                answer = cnt;
                break;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj]) continue;
                if(maps[ni][nj]==0) continue;
                visited[ni][nj] = true;
                q.offer(new int[]{ni,nj,cnt+1});
            }
        }
        return answer;
    }
}
