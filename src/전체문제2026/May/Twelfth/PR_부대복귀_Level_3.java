package 전체문제2026.May.Twelfth;

import java.util.*;

public class PR_부대복귀_Level_3 {

    public static void main(String[] args) {
        int n = 5;
        int[][]roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[]sorces = {1,3,5};
        int destination = 5;
        System.out.println(Arrays.toString(solution(n,roads,sorces,destination)));

    }
    static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};
        List<List<Integer>>list = new ArrayList<>();
        for(int i=0;i<n+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<roads.length;i++){
            int a = roads[i][0];
            int b = roads[i][1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{destination,0});
        boolean[]visited = new boolean[n+1];
        visited[destination]= true;
        int[]dist = new int[n+1];
        Arrays.fill(dist,-1);
        while(!q.isEmpty()){
            int[]c = q.poll();
            int node = c[0]; int cnt = c[1];
            dist[node] = cnt;
            for(int next : list.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
        answer = new int[sources.length];
        for(int i=0;i<sources.length;i++) answer[i] = dist[sources[i]];
        return answer;
    }
}
