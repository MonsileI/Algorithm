package 구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PR_도넛과막대그래프_Level_2 {


    static List<List<Integer>> list;
    static int N;
    static boolean[]visited;
    static int[]answer;
    static boolean flag;
    static int[] solution(int[][] edges) {
            answer = new int[4];
            //생선한 가운데 Node ,  도넛, 막대, 8자
            list = new ArrayList<>();
            int max = 0;
            for(int i=0;i<edges.length;i++){
                max = Math.max(max,edges[i][0]);
                max = Math.max(max,edges[i][1]);
            }
            N = max;
            int[]dist = new int[N+1];
            for(int i=0;i<edges.length;i++) dist[edges[i][0]]++;
            max = 0;
            int node = 0;
            for(int i=0;i<N+1;i++){
                list.add(new ArrayList<>());
                if(max<dist[i]){
                    max = dist[i];
                    node = i;
                }
            }
            for(int i=0;i<edges.length;i++) list.get(edges[i][0]).add(edges[i][1]);

            answer[0] = node;
            for(int next : list.get(node)){
                visited = new boolean[N+1];
                flag = false;
                dfs(next);
                if(!flag)answer[2]++;
            }


            return answer;
    }

    static void dfs(int node){
        if(flag) return;
        if(visited[node]){
            flag= true;
            answer[1]++;
            return;
        }
        if(list.get(node).size()>1){
            flag=  true;
            answer[3]++;
            return;
        }
        visited[node] = true;
        for(int next : list.get(node)) dfs(next);

    }


    public static void main(String[] args) {
        /*
        TEST  CASE
        int[][] edges = {{2, 3}, {4, 3}, {1, 1}, {2, 1}};    result = {2, 1, 1, 0};
        int[][] edges = {{4, 11}, {1, 12}, {8, 3}, {12, 7},
        {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};    result = {4, 0, 1, 2};
        * */
        int[][] edges = {{4, 11}, {1, 12}, {8, 3}, {12, 7},
                {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
        System.out.println(Arrays.toString(solution(edges)));
    }
}
