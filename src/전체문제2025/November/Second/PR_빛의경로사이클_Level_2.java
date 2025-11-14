package 전체문제2025.November.Second;

import java.util.*;

public class PR_빛의경로사이클_Level_2 {
    static char[][]map;
    static int N,M;
    static int answer;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][][]visited;
    public static void main(String[] args) {
        String[]grid = {"R","R"};
        int [] result = solution(grid);
        System.out.println(Arrays.toString(result));
    }
    static int[] solution(String[] grid) {

        N = grid.length;
        M = grid[0].length();
        map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = grid[i].toCharArray();
        visited = new boolean[N][M][4];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int d=0;d<4;d++){
                    if(visited[i][j][d]) continue;
                    int cnt = dfs(i,j,d);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        int[]answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    static int dfs(int i,int j,int d){

        int ni = 0;
        int nj = 0;
        int cnt = 0;
        while(!visited[i][j][d]) {
            visited[i][j][d] = true;
            if (map[i][j] == 'R') {
                d = (d + 1) % 4;
            }
            if (map[i][j] == 'L') {
                d = (d + 3) % 4;
            }
            ni = i + move[d][0];
            nj = j + move[d][1];
            if (ni < 0) {
                ni = N - 1;
            }
            if (nj < 0) {
                nj = M - 1;
            }
            if (N - 1 < ni) {
                ni = 0;
            }
            if (M - 1 < nj) {
                nj = 0;
            }
            i = ni; j = nj;
            cnt++;
        }
        return cnt;
    }

}
