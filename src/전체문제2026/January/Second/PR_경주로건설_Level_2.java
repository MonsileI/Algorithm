package 전체문제2026.January.Second;

import java.util.*;

public class PR_경주로건설_Level_2 {
    public static void main(String[] args) {
        int[][]board = {{0, 0, 0, 0, 0},{0, 1, 1, 1, 0},{0, 0, 1, 0, 0},{1, 0, 0, 0, 1},{1, 1, 1, 0, 0}};
        System.out.println(solution(board));
    }
    static int solution(int[][] board) {
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        int answer = Integer.MAX_VALUE;
        int N = board.length;
        int M = board[0].length;
        Queue<int[]> q= new ArrayDeque<>();
        for(int d=0;d<4;d++) q.offer(new int[]{0,0,d,0}); //좌표(i,j) , 방향 (d), 비용(100원);
        int[][]visited = new int[N][M];
        for(int i=0;i<N;i++) Arrays.fill(visited[i],987654321);
        visited[0][0] = 100;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int dir = c[2]; int weight = c[3];
            if(answer<=weight) continue;
            if(i==N-1 && j==M-1){
                answer = weight;
                continue;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                int nw = weight;
                if(d==dir){
                    nw += 100;
                }else{
                    nw += 600;
                }
                if(ni <0||nj<0||N-1<ni||M-1<nj) continue;
                if(board[ni][nj]==1) continue;
                if(visited[ni][nj]+200 < nw) continue;
                visited[ni][nj] = nw;
                q.offer(new int[]{ni,nj,d,nw});

            }
        }
        return answer;
    }
}
