package 그래프이론.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_21924_도시건설_Gold_4 {
    static class Node implements Comparable<Node>{
        int from; int to; long weight;

        public Node(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return (int)(weight - o.weight);
        }
    }
    static int [] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i=1;i<N+1;i++) parents[i] = i;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long sumWeight = 0;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long w = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a,b,w));
            sumWeight += w;
        }
        long answer = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(find(now.from)!=find(now.to)){
                union(now.from,now.to);
                cnt++;
                answer += now.weight;
            }
            if(cnt==N-1) break;
        }
        if(cnt!=N-1) System.out.println(-1);
        else System.out.println(sumWeight-answer);
    }


    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
}
