package 구현.최대힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2843_콘센트_Gold_5 {
    static class Node implements Comparable<Node>{
        int num ;

        public Node(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return -(num-o.num);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node[] arr = new Node[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < N ; i++) arr[i] = new Node(Integer.parseInt(st.nextToken()));
        Arrays.sort(arr);
        PriorityQueue<Integer> q = new PriorityQueue<>();

        long max = 0;

        if(N > M) {
            for(int i = 0 ; i<M ; i++)  q.add(arr[i].num);

            for(int i = M ; i < N ; i++) {
                int now = q.poll();
                int next = now + arr[i].num;
                q.add(next);
            }
            for(int i = 0 ; i < M ; i++) {
                if(i != M-1) q.poll();
                else max = q.poll();
            }

        }
        else  max = arr[0].num;
        System.out.println(max);

    }
}
