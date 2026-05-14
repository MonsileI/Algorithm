package 전체문제2026.May.Fifth;

import java.util.*;
public class PR_더맵게_Level_2 {
    public static void main(String[] args) {
        int[]scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville,K));
    }
    static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++) pq.offer(scoville[i]);
        boolean flag = false;
        while(!pq.isEmpty()){
            int min = pq.poll();
            if(K<=min) {
                flag= true;
                break;
            }
            if(pq.isEmpty()) {
                flag =  false;
                break;
            }
            int second = pq.poll();
            pq.offer(min + (second*2));
            answer++;
        }
        return flag ? answer : -1;
    }
}
