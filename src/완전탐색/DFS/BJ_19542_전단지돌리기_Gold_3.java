package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_19542_전단지돌리기_Gold_3 {
    static int N;
    static List<List<Integer>> list;
    static int D;
    static int cnt;
    static int [] depth;
    static int S;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N= Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D= Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        depth = new int[N+1];
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(S,-1);
        System.out.println(cnt*2);
    }
    static int dfs(int node,int parent){
        for(int next : list.get(node)){
            if(next!=parent){
                depth[node] =Math.max(depth[node],dfs(next,node)+1);
            }
        }
        if(node!=S && depth[node]>=D) cnt++;
        return depth[node];
    }
}