package 구현.누적합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1202_보석도둑_Gold_2 {

    static class Node implements Comparable<Node>{
        int weight; int price;

        public Node(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return weight == o.weight ? -(price-o.price) :weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node[]arr= new Node[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i] = new Node(w,p);
        }
        int[]beg = new int[M];
        for(int i=0;i<M;i++) beg[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        Arrays.sort(beg);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->-(o1-o2));
        long answer = 0;
        int idx = 0;
        for(int b : beg){
            while(idx<N&&arr[idx].weight<=b){
                pq.offer(arr[idx].price);
                idx++;
            }
            if(!pq.isEmpty()){
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }

}
