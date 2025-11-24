package 전체문제2025.November.Eighth;

import java.util.*;

public class PR_리코쳇로봇_Level_2 {
    public static void main(String[] args) {
        String[]board = {".D.R", "....", ".G..", "...D"};
        System.out.println(solution(board));
    }
    static int solution(String[] board) {
        int answer = -1;
        int N = board.length;
        int M = board[0].length();
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

        char[][]map = new char[N][M];
        boolean[][]visited = new boolean[N][M];
        int si =0 ;int sj = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j]=='R'){
                    si = i;
                    sj = j;
                }
            }
        }
        visited[si][sj] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si,sj,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i =c[0];
            int j =c[1];
            int cnt = c[2];
            if(map[i][j]=='G'){
                answer = cnt;
                break;
            }
            for(int d=0;d<4;d++){
                int ti = i;
                int tj = j;
                while(true){
                    int ni = ti + move[d][0];
                    int nj = tj + move[d][1];
                    //벽에 부딪히는 경우
                    if(ni<0||nj<0||N-1<ni||M-1<nj||map[ni][nj]=='D'){
                        if(!visited[ti][tj]){
                            visited[ti][tj] = true;
                            q.offer(new int[]{ti,tj,cnt+1});
                        }
                        break;
                    }
                    ti = ni; tj = nj;
                }
            }
        }
        return answer;
    }
}
