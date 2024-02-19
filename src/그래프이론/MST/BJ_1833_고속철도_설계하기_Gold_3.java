package 그래프이론.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1833_고속철도_설계하기_Gold_3 {

    static class Node implements Comparable<Node>{
        int from; int to; int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    static int[]parents;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        parents = new int[N+1];
        for(int i=1;i<N+1;i++) parents[i] = i;
        StringTokenizer st=  null;
        int sum  =0;
        boolean[][]visited = new boolean[N+1][N+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
                int num = Integer.parseInt(st.nextToken());
                if(i==j) continue;
                if(num<0){
                    if(!visited[i][j]){
                        visited[i][j] = visited[j][i] = true;
                        union(i,j);
                        sum += (num*-1);
                    }
                }
                else{
                    pq.offer(new Node(i,j,num));
                }
            }
        }
        int newOne = 0;
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(find(now.from)!=find(now.to)){
                sum += now.weight;
                int min = Math.min(now.from,now.to);
                int max = Math.max(now.from,now.to);
                union(now.from,now.to);
                sb.append(min+" "+max+"\n");
                newOne++;
            }
        }
        sb.insert(0,sum+" "+newOne+"\n");
        System.out.println(sb.toString());

    }

    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parents[rootB]= rootA;
        else parents[rootA] = rootB;
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
}
