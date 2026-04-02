package 전체문제2026.April.Second;

import java.util.*;
import java.io.*;
public class BJ_2533_사회망서비스_Gold_3 {
    static int N;
    static int[]parent;
    static List<List<Integer>> list;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        list = new ArrayList<>();
        parent = new int[N+1];
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        parent[1] = 0;
        dfs(0,1);
        System.out.println(answer);
    }
    static int dfs(int parent,int node){
        if(list.get(node).size()==1 && list.get(node).get(0)==parent) return 1;
        int tmp = 0;
        for(int next : list.get(node)){
            if(next==parent) continue;
            tmp += dfs(node,next);
        }
        if(tmp==0) return 1;
        answer++;
        return 0;
    }
}
