package 전체문제2026.September.Fifth;

import java.util.*;
import java.io.*;
public class GR_그래프의밀집도_D3 {
    static int N;
    static List<List<Integer>> list;
    static boolean[]visited;
    static int[]rootNode;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<=N;i++) list.add(new ArrayList<>());
        visited = new boolean[N+1];
        rootNode = new int[N+1];
        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        double max = 0;
        int answerNode = 0;
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                visited[i] = true;
                double cnt = bfs(i); //밀도
                if(max<cnt) {
                    max = cnt;
                    answerNode = i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            if(rootNode[i]==answerNode){
                sb.append(i+" ");
            }
        }
        System.out.println(sb.toString());
    }
    static double bfs(int node){
        double cnt = 1;
        rootNode[node] = node;
        Queue<Integer> q= new ArrayDeque<>();
        q.offer(node);
        double lineCnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : list.get(cur)){
                lineCnt++;
                if(!visited[next]){
                    visited[next] = true;
                    rootNode[next] = node;
                    cnt++;
                    q.offer(next);
                }
            }
        }
        if(cnt==0 || lineCnt == 0) return 0;
        return ((lineCnt/2)/cnt);
    }
}
