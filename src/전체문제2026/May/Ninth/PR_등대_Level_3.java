package 전체문제2026.May.Ninth;

import java.util.*;
public class PR_등대_Level_3 {
    static int N;
    static List<List<Integer>> list;
    static int [][]Light;
    static int answer;
    public static void main(String[] args) {
        int n = 10;
        int[][]lighthouse = {{4, 1},{5, 1},{5, 6},{7, 6},{1, 2},{1, 3},{6, 8},{2, 9},{9, 10}};
        System.out.println(solution(n,lighthouse));
    }
    static int solution(int n, int[][] lighthouse) {
        N = n;
        Light = lighthouse;
        list =new ArrayList<>();
        for(int i=0;i<n+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<lighthouse.length;i++){
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(0,1);
        return answer;
    }
    static int dfs(int before,int cur){
        if(list.get(cur).size()==1 && before == list.get(cur).get(0)){
            return 1;
        }
        int tmp = 0;
        for(int next : list.get(cur)){
            if(next==before) continue;
            tmp += dfs(cur,next);
        }
        if (tmp == 0) {
            return 1;
        } else {
            answer++;
        }
        return 0;
    }
}
