package 구현.최대힙;

import java.util.PriorityQueue;

public class PR_프로세스_Level_2 {
    static int solution(int[] priorities, int location) {
        int answer = 0;
        int idx = 0;
        int turn = 1;
        int N = priorities.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> - (o1-o2));
        for(int i : priorities) pq.offer(i);
        while(true){
            if(pq.peek()==priorities[idx]){
                pq.poll();
                if(idx==location){
                    answer = turn;
                    break;
                }
                turn++;
            }
            idx++;
            if(idx==N) idx = 0;
        }
        return answer;
    }
    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int[]priorities = {2, 1, 3, 2};
        int location = 2;

        int return = 1;

        2.
        int[]priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        int return = 5;
        * */
        int[]priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities,location));
    }
}
