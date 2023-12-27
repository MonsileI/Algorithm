package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class gr_작은노드_Level_3 {

    static boolean[]visited;
    static int last;
    static int nodeCnt;
    static List<PriorityQueue<Integer>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new PriorityQueue<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).offer(b);
            list.get(b).offer(a);
        }
        visited = new boolean[N+1];
        visited[s] = true;
        dfs(s,1);
        System.out.println(nodeCnt+" "+last);
    }
    static void dfs(int node,int cnt){
        PriorityQueue<Integer> pq = list.get(node);
        while(!pq.isEmpty()){
            int next = pq.poll();
            if(!visited[next]){
                visited[next] = true;
                dfs(next,cnt+1);
                return;
            }
        }

        last = node;
        nodeCnt = cnt;
        return;

    }
}
