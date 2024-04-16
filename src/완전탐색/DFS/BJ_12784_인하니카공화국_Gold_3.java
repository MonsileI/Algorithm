package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_12784_인하니카공화국_Gold_3 {
    static class Node {
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static int N;
    static List<List<Node>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        for(int t=0;t<TC;t++){
            st =  new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
            int M = Integer.parseInt(st.nextToken());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a =  Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                list.get(a).add(new Node(b,w));
                list.get(b).add(new Node(a,w));
            }
            int sum = 0;
            for(Node next : list.get(1)) sum += dfs(next.to,1,next.weight);
            sb.append(sum+"\n");
        }
        System.out.println(sb.toString());
    }

    static int dfs(int node, int parent,int weight){
        if(list.get(node).size()==1) return list.get(node).get(0).weight;
        int sum = 0;
        for(Node next : list.get(node)){
            if(next.to==parent) continue;
            sum += dfs(next.to,node,next.weight);
        }
        return Math.min(sum,weight);
    }
}
