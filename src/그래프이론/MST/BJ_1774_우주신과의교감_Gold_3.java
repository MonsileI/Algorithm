package 그래프이론.MST;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1774_우주신과의교감_Gold_3 {
    static class Node implements Comparable<Node>{
        int from; int to; double weight;

        public Node(int from,int to,double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;

        }

        @Override
        public int compareTo(Node o) {
            if(weight < o.weight) return - 1;
            return 1;
        }
    }
    static int N;
    static int [] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 1; i < N + 1; i++) parents[i] = i;
        int M = Integer.parseInt(st.nextToken());
        int[][]dist = new int[N+1][2];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            dist[i][0] = Integer.parseInt(st.nextToken());
            dist[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (find(i) != find(j)) {
                   double weight = calc(dist[i][0],dist[i][1],dist[j][0],dist[j][1]);
                   pq.offer(new Node(i,j,weight));
                }
            }
        }
        double sum = 0.0000;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int fp = find(now.from);
            int sp = find(now.to);
            if(fp!=sp){
                union(fp,sp);
                sum += now.weight;
            }
        }
        String result = String.format("%.2f",sum);
        System.out.println(result);
    }
    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(parents[rootA]<parents[rootB]) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
    static double calc(int x1,int y1,int x2,int y2){
        return Math.sqrt(Math.pow(Math.abs(x1-x2),2) + Math.pow(Math.abs(y1-y2),2));
    }
}
