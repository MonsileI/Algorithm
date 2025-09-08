package 전체문제2025.August.First;

import java.util.*;
import java.io.*;
public class BJ_1417_국회의원선거_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        N--;
        int dasom = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1, o2) -> -(o1 - o2)
        );
        for(int i=0;i<N;i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while(true){
            if(pq.isEmpty()){
                break;
            }
            int cur = pq.poll();
            if(dasom <= cur){
                cur--;
                dasom++;
                answer++;
                pq.offer(cur);
            }else {
                break;
            }
        }
        System.out.println(answer);

    }
}
