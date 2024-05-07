package 전체문제.sixth_month_2024_05.fourth_2024_05_04;


import java.util.*;
import java.io.*;
public class BJ_1781_컵라면_Gold_2 {

    static class Node implements Comparable<Node>{
        int count; int dead;

        public Node(int count, int dead) {
            this.count = count;
            this.dead = dead;
        }

        @Override
        public int compareTo(Node o) {
            return dead==o.dead ? o.count - count: dead - o.dead;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Node[]arr = new Node[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int dead = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            arr[i] = new Node(count,dead);
        }
        Arrays.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pq.offer(arr[i].count);
            if(arr[i].dead< pq.size()) pq.poll();
        }
        long ans = 0;
        while(!pq.isEmpty()) ans += pq.poll();
        System.out.println(ans);
    }
}
