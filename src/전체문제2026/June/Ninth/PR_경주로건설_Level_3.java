package 전체문제2026.June.Ninth;

import java.util.*;

public class PR_경주로건설_Level_3 {

    public static void main(String[] args) {
        int[][]board = {{0,0,0,0,0,0,0,1}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,1,0,0}, {0,0,0,0,1,0,0,0}, {0,0,0,1,0,0,0,1}, {0,0,1,0,0,0,1,0}, {0,1,0,0,0,1,0,0}, {1,0,0,0,0,0,0,0}};
        System.out.println(solution(board));
    }
    static int[][]map;
    static int N,M;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int solution(int[][] board) {
        map = board;
        N = board.length;
        M = board[0].length;
        int[][][]visited = new int[N][M][4];
        Queue<int[]> q= new ArrayDeque<>();
        for(int d=0;d<4;d++) {
            q.offer(new int[]{0, 0, 0,d});
            visited[0][0][d] = 100;
        }
        int INF = Integer.MAX_VALUE;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                Arrays.fill(visited[i][j], INF);
            }
        }
        int answer = INF;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];int cnt = c[2]; int dir = c[3];
            if(answer<=cnt) continue;
            if(i==N-1 && j==M-1){
                answer = cnt;
                continue;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(!canMove(ni,nj)) continue;
                int tmp = cnt+100;
                if(dir!=d){
                    tmp += 500;
                }
                if(visited[ni][nj][d] <= tmp) continue;
                visited[ni][nj][d] = tmp;

                q.offer(new int[]{ni,nj,tmp,d});
            }
        }
        return answer;
    }
    static boolean canMove(int i,int j){
        if(i<0||j<0||N-1<i||M-1<j) return false;
        if(map[i][j]==1) return false;
        return true;
    }

}
