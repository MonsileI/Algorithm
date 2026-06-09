package 전체문제2026.June.Fifth;

import java.util.*;

public class PR_PCCP_석유시추_Level_2 {
    public static void main(String[] args) {
        int[][]land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        System.out.println(solution(land));
    }
    static int N,M;
    static int[][]map;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][]nodeMap;
    static int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        map = new int[N][M];
        visited = new boolean[N][M];
        nodeMap = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = land[i][j];
            }
        }
        int idx = 1;
        List<Integer> idxList = new ArrayList<>();
        idxList.add(-1);
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && map[i][j]==1){
                    visited[i][j] = true;
                    nodeMap[i][j] = idx;
                    int sum = bfs(i,j,idx);
                    idx++;
                    idxList.add(sum);
                }
            }
        }
        int answer = 0;
        for(int j=0;j<M;j++){
            boolean[]check = new boolean[idx];
            int tmp = 0;
            for(int i=0;i<N;i++){
                if(map[i][j]==0) continue;
                int node = nodeMap[i][j];
                if(check[node]) continue;
                check[node] = true;
                tmp += idxList.get(node);
            }
            answer = Math.max(answer,tmp);
        }
        return answer;
    }
    static int bfs(int y,int x, int idx){
        int sum = 1;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj]==0) continue;
                visited[ni][nj] = true;
                sum++;
                nodeMap[ni][nj] = idx;
                q.offer(new int[]{ni,nj});
            }
        }
        return sum;
    }
}
