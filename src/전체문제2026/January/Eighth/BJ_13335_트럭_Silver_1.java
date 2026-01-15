package 전체문제2026.January.Eighth;

import java.util.*;
import java.io.*;
public class BJ_13335_트럭_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Queue<Integer> truck = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i= 0; i< n; i++) truck.offer(Integer.parseInt(st.nextToken()));
        int time = 0;
        int bw=0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i =0; i<w ; i++) q.offer(0);

        while(!q.isEmpty()) {
            time++;
            bw-=q.poll();
            if(!truck.isEmpty()) {
                if(truck.peek()+bw<=L) {
                    bw+=truck.peek();
                    q.offer(truck.poll());
                }else {
                    q.offer(0);
                }
            }
        }
        System.out.println(time);
    }
}
