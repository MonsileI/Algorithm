package 전체문제.sixth_month_2024_05.fifth_2024_05_07;


import java.util.*;
import java.io.*;
public class BJ_1781_컵라면_Gold_2 {
    static class Node implements Comparable<Node>{
        int dead; int count;

        public Node(int dead, int count) {
            this.dead = dead;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return dead == o.dead ? o.count - count : dead - o.dead;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Node[]arr=  new Node[N];
        for(int i=0;i<N;i++){
            st=  new StringTokenizer(br.readLine()," ");
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Node node = new Node(d,c);
            arr[i] = node;
        }
        Arrays.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pq.offer(arr[i].count);
            if(arr[i].dead<pq.size()) pq.poll();
        }
        long ans  = 0;
        while(!pq.isEmpty()) ans += pq.poll();
        System.out.println(ans);


    }
}
