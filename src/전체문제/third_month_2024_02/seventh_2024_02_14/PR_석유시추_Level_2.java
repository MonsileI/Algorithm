package 전체문제.third_month_2024_02.seventh_2024_02_14;

import java.util.*;

public class PR_석유시추_Level_2 {

    static int[][]visited;
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int N,M;
    static int solution(int[][] land) {
        int answer = 0;
        map = land;
        N = land.length;
        M = land[0].length;
        visited = new int[N][M];
        //visited를 number를 먹이자.
        int idx = 1;
        Map<Integer,Integer> sumBFS = new HashMap<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(visited[i][j]==0 && map[i][j]==1){
                    visited[i][j] = idx;
                    int sum = bfs(i,j,idx);
                    sumBFS.put(idx,sum);
                    idx++;
                }
            }
        }
        boolean [] check=  null;
        for(int j=0;j<M;j++){
            int sum  =0;
            check=  new boolean[idx+1];
            for(int i=0;i<N;i++){
                if(visited[i][j]!=0 && !check[visited[i][j]]){
                    check[visited[i][j]]=true;
                    sum += sumBFS.get(visited[i][j]);
                }
            }
            answer = Math.max(answer,sum);
        }

        return answer;
    }
    static int bfs(int y,int x,int v){
        int cnt = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj]==0 && map[ni][nj]==1){
                    visited[ni][nj] = v;
                    cnt++;
                    q.offer(new int[]{ni,nj});
                }

            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int[][]land = {{0, 0, 0, 1, 1, 1, 0, 0},{0, 0, 0, 0, 1, 1, 0, 0},{1, 1, 0, 0, 0, 1, 1, 0},{1, 1, 1, 0, 0, 0, 0, 0},{1, 1, 1, 0, 0, 0, 1, 1}};
        int result = 9;

        2.
        int[][]land = {{1, 0, 1, 0, 1, 1},{1, 0, 1, 0, 0, 0},{1, 0, 1, 0, 0, 1},{1, 0, 0, 1, 0, 0},{1, 0, 0, 1, 0, 1},{1, 0, 0, 0, 0, 0},{1, 1, 1, 1, 1, 1}};
        int result = 16;
        * */
        int[][]land = {{1, 0, 1, 0, 1, 1},{1, 0, 1, 0, 0, 0},{1, 0, 1, 0, 0, 1},{1, 0, 0, 1, 0, 0},{1, 0, 0, 1, 0, 1},{1, 0, 0, 0, 0, 0},{1, 1, 1, 1, 1, 1}};
        System.out.println(solution(land));
    }
}
