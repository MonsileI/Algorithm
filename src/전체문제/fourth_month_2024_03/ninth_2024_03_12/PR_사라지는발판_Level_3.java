package 전체문제.fourth_month_2024_03.ninth_2024_03_12;

public class PR_사라지는발판_Level_3 {

    static int[][]map;
    static int N,M;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int solution(int[][] board, int[] aloc, int[] bloc) {
        map = board;
        N = board.length; M = board[0].length;
        return dfs(aloc[0],aloc[1],bloc[0],bloc[1]);
    }
    static int dfs(int px,int py,int ox,int oy){
        if(map[px][py]==0) return 0;
        int ret = 0;
        for(int d=0;d<4;d++) {
            int ni = px + move[d][0];
            int nj = py + move[d][1];
            if (ni < 0 || nj < 0 || N - 1 < ni || M - 1 < nj) continue;
            if (map[ni][nj] == 0) continue;
            map[px][py] = 0;
            int val = dfs(ox, oy, ni, nj) + 1;
            map[px][py] = 1;
            if (ret % 2 == 0 && val % 2 == 1) {
                ret = val;
            } else if (ret % 2 == 0 && val % 2 == 0) {
                ret = ret > val ? ret : val;
            } else if (ret % 2 == 1 && val % 2 == 1) {
                ret = ret < val ? ret : val;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int[][]board = {{1, 1, 1},{1, 1, 1},{1, 1, 1}};
        int[]aloc = {1,0}; int[]bloc = {1,2};
        int result = 5;
        2.
        int[][]board = {{1, 1, 1},{1, 0, 1},{1, 1, 1}};
        int[]aloc = {1,0}; int[]bloc = {1,2};
        int result = 4;
        3.
        int[][]board = {{1, 1, 1, 1, 1}};
        int[]aloc = {0,0}; int[]bloc = {0,4};
        int result = 4;
        4.
        int[][]board = {{1}};
        int[]aloc = {0,0}; int[]bloc = {0,0};
        int result = 0;
        * */
        int[][]board = {{1, 1, 1},{1, 1, 1},{1, 1, 1}};
        int[]aloc = {1,0}; int[]bloc = {1,2};
        System.out.println(solution(board,aloc,bloc));

    }
}
