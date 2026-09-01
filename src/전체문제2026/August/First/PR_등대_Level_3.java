package 전체문제2026.August.First;

import java.util.*;

public class PR_등대_Level_3 {
    public static void main(String[] args) {
        int n = 10;
        int[][]lighthouse = {{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}};
        System.out.println(solution(n,lighthouse));
    }
    static List<List<Integer>> list;
    static int answer;
    static boolean[]visited;
    static int solution(int n, int[][] lighthouse) {
        list = new ArrayList<>();
        for(int i=0;i<=n;i++) list.add(new ArrayList<>());
        for(int i=0;i<lighthouse.length;i++){
            list.get(lighthouse[i][0]).add(lighthouse[i][1]);
            list.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }
        visited = new boolean[n+1];
        dfs(0,1);
        return answer;
    }
    static int dfs(int before, int cur){
        visited[cur] = true;
        if(list.get(cur).size()==1 && list.get(cur).get(0)==before) return 1;
        int tmp = 0;
        for(int next : list.get(cur)){
            if(!visited[next]) {
                tmp += dfs(cur, next);
            }
        }
        if(tmp!=0){
            answer++;
            return 0;
        }
        return 1;
    }
}
