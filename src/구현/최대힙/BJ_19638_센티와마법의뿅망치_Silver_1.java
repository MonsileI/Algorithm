package 구현.최대힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_19638_센티와마법의뿅망치_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->-(o1-o2));
        for(int i=0;i<N;i++) pq.offer(Integer.parseInt(br.readLine()));
        boolean flag = true;
        int ans = 0;
        while(true){
            if(pq.peek()<H) break;
            if(ans==cnt){
                flag = false;
                break;
            }
            if(pq.peek()==1){
                flag= false;
                break;
            }
            int num = pq.poll()/2;
            pq.offer(num);
            ans++;
        }
        if(flag) System.out.println("YES\n"+ans);
        else System.out.println("NO\n"+pq.peek());

    }
}
