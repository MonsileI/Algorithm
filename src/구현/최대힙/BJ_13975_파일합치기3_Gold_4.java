package 구현.최대힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_13975_파일합치기3_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int i=0;i<N;i++)pq.offer(Long.parseLong(st.nextToken()));
            long ans = 0;
            while(!pq.isEmpty()){
                long a = pq.poll();
                if(pq.isEmpty())  break;
                long b = pq.poll();
                ans += (a+b);
                pq.offer(a+b);
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());

    }
}
