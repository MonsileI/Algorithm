package 구현.최대힙;

import java.util.PriorityQueue;

public class PR_더맵게_Level_2 {
    static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = scoville.length;
        for(int num : scoville)pq.offer(num);
        int answer = 0;
        while(true){
            if(pq.isEmpty()){
                answer = -1;
                break;
            }
            int f = pq.poll();
            if(f>=K) break;
            if(pq.isEmpty()){
                answer = -1;
                break;
            }
            int s= pq.poll();
            int newOne = f + (s*2);
            pq.offer(newOne);
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[]scoville = {1,2,3,9,10,12};
        int K = 7;
        //return = 2;
        System.out.println(solution(scoville,K));
    }
}
