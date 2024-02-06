package 완전탐색.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PR_가장먼노드_Level_2 {
    static int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<edge.length;i++){
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{1,0});
        boolean[]visited= new boolean[n+1];
        visited[1] = true;
        int[]result = new int[n+1];
        int max = 0;
        while(!q.isEmpty()){
            int []c= q.poll();
            int node = c[0]; int cnt = c[1];
            max = Math.max(max,cnt);
            result[node] = cnt;
            for(int next : list.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    result[next] = cnt;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
        for(int i=1;i<n+1;i++){
            if(result[i]==max)answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        int n = 6;
        int [][] vertex = {{3, 6},{4, 3},{3, 2},{1, 3},{1, 2},{2, 4},{5, 2}};

        int return = 3;
        * */
        int n = 6;
        int [][] vertex = {{3, 6},{4, 3},{3, 2},{1, 3},{1, 2},{2, 4},{5, 2}};
        System.out.println(solution(n,vertex));
    }
}
