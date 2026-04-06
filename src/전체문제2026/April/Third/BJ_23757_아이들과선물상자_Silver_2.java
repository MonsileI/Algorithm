package 전체문제2026.April.Third;

import java.util.*;
import java.io.*;
public class BJ_23757_아이들과선물상자_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int G = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < G; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            int child = Integer.parseInt(st.nextToken());

            if(pq.isEmpty()) {
                System.out.println(0);
                return;
            }

            int top = pq.poll();

            if(top < child) {
                System.out.println(0);
                return;
            }

            if(top - child > 0) {
                pq.offer(top - child);
            }
        }

        System.out.println(1);
    }
}
