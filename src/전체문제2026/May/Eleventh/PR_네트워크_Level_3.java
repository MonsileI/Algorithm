package 전체문제2026.May.Eleventh;

import java.util.*;

public class PR_네트워크_Level_3 {
    static int N;
    static List<List<Integer>> list;
    static boolean[]visited;
    public static void main(String[] args) {
        int n = 3;
        int[][]computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(n,computers));
    }
    static int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        list = new ArrayList<>();
        for(int i=0;i<N;i++) list.add(new ArrayList<>());
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j) continue;
                if(computers[i][j]==1){
                    list.get(i).add(j);
                }
            }
        }
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                bfs(i);
                answer++;
            }
        }
        return answer;
    }
    static void bfs(int node){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : list.get(cur)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
