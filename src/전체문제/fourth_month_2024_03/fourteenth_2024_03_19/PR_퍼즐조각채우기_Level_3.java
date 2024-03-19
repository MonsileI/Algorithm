package 전체문제.fourth_month_2024_03.fourteenth_2024_03_19;
import java.util.*;
public class PR_퍼즐조각채우기_Level_3 {
    static int answer;
    static int N,M;
    static boolean[][]visited;
    static List<List<int[]>> list;
    static int idx;
    static int [][]move= {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][]G;
    static int[][]T;
    static int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        M = game_board[0].length;
        G = game_board;
        T = table;
        visited = new boolean[N][M];
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&table[i][j]==1){
                    bfs(i,j);
                }
            }
        }
        
        return answer;
    }
    static void bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        list.add(new ArrayList<>());
        list.get(idx).add(new int[]{y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&T[ni][nj]==1){
                    visited[ni][nj] = true;
                    list.get(idx).add(new int[]{ni,nj});
                    q.offer(new int[]{ni,nj});
                }
            }
        }

        idx++;

    }
    public static void main(String[] args) throws Exception {
        /*
        TEST CASE
        1.
        int[][]game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}}
        int[][]table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
        int result = 14;

        2.
        int[][]game_board = {{0,0,0},{1,1,0},{1,1,1}}
        int[][]table = {{1,1,1},{1,0,0},{0,0,0}};
        int result = 0
        * */
        int[][]game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][]table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
        System.out.println(solution(game_board,table));
    }
}
