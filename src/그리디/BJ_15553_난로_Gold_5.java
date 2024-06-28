package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_15553_난로_Gold_5 {
    static class Node implements Comparable<Node>{
        int idx; int range;

        public Node(int idx, int range) {
            this.idx = idx;
            this.range = range;
        }

        @Override
        public int compareTo(Node o) {
            return -(range-o.range);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int ans = 0;
        if(K==1) ans = arr[N-1] - arr[0] + 1;
        else {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int i = 0; i < N - 1; i++) pq.offer(new Node(i + 1, arr[i + 1] - arr[i]));
            boolean[] check = new boolean[N];
            K--;
            while (0 < K) {
                Node node = pq.poll();
                check[node.idx] = true;
                K--;
            }
            int start = arr[0];
            int end = arr[0];
            for (int i = 0; i < N; i++) {
                if (check[i]) {
                    ans += (end - start) + 1;
                    start = arr[i];
                    end = arr[i];
                    continue;
                }
                end = arr[i];
            }
            ans += (end-start)+1;
        }
        System.out.println(ans);
    }
}
