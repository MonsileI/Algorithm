package 전체문제.eleventh_month_2025_02.first_2024_02_01;

import java.util.*;

public class PR_충돌위험찾기_Level_2 {

    public static void main(String[] args) {
/*
        int[][]points = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][]routes = {{4, 2}, {1, 3}, {2, 4}};
*/
        int[][]points ={{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][]routes = {{4, 2}, {1, 3}, {4, 2}, {4, 3}};
  /*
        int[][]points = {{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}};
        int[][]routes = {{2, 3, 4, 5}, {1, 3, 4, 5}};
*/
        System.out.println(solution(points,routes));

    }
    static int[][]move = {{-1,0},{1,0},{0,-1},{0,1}};
    static int solution(int[][]points,int[][]routes) {

        for (int i = 0; i < points.length; i++) {
            points[i][0]--;
            points[i][1]--;
        }
        for (int i = 0; i < routes.length; i++) {
            routes[i][0]--;
            routes[i][1]--;
        }
        //r이 c보다 선행됨
        int max = 0;
        List<List<int[][]>> route = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            int len = routes[i].length;
            List<int[][]> list = new ArrayList<>();
            int totalLen = 0;
            for (int j = 0; j < len-1; j++) {
                int[] start = points[routes[i][j]]; //4
                int[] end = points[routes[i][j+1]];   //2
                int[][]value = bfs(start,end);
                int valueSize = value.length;
                totalLen += valueSize;
                list.add(value);
            }
                max = Math.max(max, totalLen - 1);
            route.add(new ArrayList<>(list));
        }
            int answer = 0;
            for (int c = 0; c < max; c++) {
                int[][] visited = new int[101][101];
                for (List<int[][]> list : route) {
                    if (list.size() < c) continue;
                    int i = list.get(c)[0][0];
                    int j = list.get(c)[0][1];
                    if (visited[i][j] == 1) {
                        answer++;
                    }
                    visited[i][j]++;
                }
            }
            return answer;
    }
    static int[][] bfs(int []start,int []end){

        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{start[0],start[1],1});
        int[][]visited=  new int[101][101];
        //부모노드찾기
        int[][][]parents = new int[101][101][2];
        parents[start[0]][start[1]][0] = start[0];
        parents[start[0]][start[1]][1] = start[1];

        visited[start[0]][start[1]] = 1;
        while(!q.isEmpty()){
            int[] node = q.poll();
            int i = node[0]; int j = node[1]; int cnt = node[2];
            if(i==end[0] && j==end[1]){
                int[][] result = new int[cnt+1][2];
                result[0][0] = end[0];
                result[0][1] = end[1];
                for(int l=1;l<cnt;l++){
                    result[l][0] = parents[i][j][0];
                    result[l][1] = parents[i][j][1];
                    i = parents[i][j][0];
                    j = parents[i][j][1];
                }
                return result;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||100<ni||100<nj) continue;
                if(visited[ni][nj]==0){
                    visited[ni][nj] = cnt;
                    parents[ni][nj][0] = i;
                    parents[ni][nj][1] = j;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }
        return null;
    }
}
