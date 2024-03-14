package 구현.최대힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1417_국회의원선거_Silver_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->-(o1-o2));
        for(int i=1;i<N;i++) pq.offer(Integer.parseInt(br.readLine()));
        int ans = 0;
        if(!pq.isEmpty()) {
            while (true) {
                if (pq.peek() < M) break;
                M++;
                ans++;
                pq.offer(pq.poll() - 1);
            }
        }
        System.out.println(ans);
    }
}
