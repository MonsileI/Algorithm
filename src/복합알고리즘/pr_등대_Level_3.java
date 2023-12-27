package 복합알고리즘;

import java.util.ArrayList;
import java.util.List;

public class pr_등대_Level_3 {

    static int N;
    static int answer;
    static List<List<Integer>> list;
    static int solution(int n, int[][] lighthouse) {
        N = n;
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<lighthouse.length;i++) {
            list.get(lighthouse[i][0]).add(lighthouse[i][1]);
            list.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }
        dfs(0,1); //부모, 나
        return answer;
    }
    static int dfs(int parent, int node){
        if(list.get(node).size()==1 && list.get(node).get(0)==parent) return 1; //리프노드
        int cnt = 0;
        for(int next : list.get(node)) {
            if(next==parent) continue;
            cnt += dfs(node,next);
        }

        if(cnt==0) return 1;
        answer++;
        return 0;
    }


    public static void main(String[] args) {
        int n = 10;
        int [][]lighthouse = {{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}};
        System.out.println(solution(n,lighthouse));
    }
}
