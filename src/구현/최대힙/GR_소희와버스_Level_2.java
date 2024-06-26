package 구현.최대힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class GR_소희와버스_Level_2 {
    static class Node implements Comparable<Node>{
        int idx; int time; int plus;

        public Node(int idx, int time, int plus) {
            this.idx = idx;
            this.time = time;
            this.plus = plus;
        }

        @Override
        public int compareTo(Node o) {
            return time == o.time ? idx - o.idx : time - o.time;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int Sohee = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.offer(new Node(i+1,s,d));
        }
        int ans = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(Sohee<=node.time){
                ans = node.idx;
                break;
            }
            node.time += node.plus;
            pq.offer(node);
        }
        System.out.println(ans);
    }
}
