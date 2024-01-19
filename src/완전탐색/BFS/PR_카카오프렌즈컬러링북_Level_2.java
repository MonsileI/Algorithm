package 완전탐색.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class PR_카카오프렌즈컬러링북_Level_2 {


    static int[][] dist = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    static boolean[][] visited;
    static int[][] map;
    static int[] answer = new int[2];
    static  int max = 0;
    static  int M;
    static  int N;
    static int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        map = picture;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && map[i][j] != 0) {
                    int cnt = bfs(i, j, map[i][j]);
                    answer[0]++;
                    max = Math.max(max, cnt);
                }
            }
        }
        answer[1] = max;

        return answer;
    }
static int bfs(int y, int x, int s){
    visited[y][x] = true;
    int cnt = 1;
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[]{y, x});
    while(!q.isEmpty()){
        int[] c = q.poll();
        int cy = c[0];
        int cx = c[1];
        for(int d = 0; d < 4; d++){
            int dy  = dist[d][0] + cy;
            int dx  = dist[d][1] + cx;
            if(dy > M - 1 || dx > N - 1 || dy < 0 || dx < 0) continue;
            if(!visited[dy][dx] && map[dy][dx] == s) {
                visited[dy][dx] = true;
                q.offer(new int[]{dy, dx});
                cnt++;
            }
        }
    }
    return cnt;
}
    public static void main(String[] args) {

        /*
        TEST CASE
        int m = 6; int n = 4; int[][]picture = {{1, 1, 1, 0},{1, 2, 2, 0},{1, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 3},{0, 0, 0, 3}};
        * */
        int m = 6; int n = 4; int[][]picture = {{1, 1, 1, 0},{1, 2, 2, 0},{1, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 3},{0, 0, 0, 3}};
        System.out.println(Arrays.toString(solution(m,n,picture)));
    }
}
