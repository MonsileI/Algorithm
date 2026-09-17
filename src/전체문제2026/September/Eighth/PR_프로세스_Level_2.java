package 전체문제2026.September.Eighth;

import java.util.*;

public class PR_프로세스_Level_2 {
    public static void main(String[] args) {
        int[]priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities,location));
    }
    static int solution(int[] priorities, int location) {
        int N = priorities.length;
        Integer[]copyMap = new Integer[N];
        Queue<Integer> q= new ArrayDeque<>();
        for(int i=0;i<N;i++) {
            q.offer(i);
            copyMap[i] = priorities[i];
        }
        Arrays.sort(copyMap,(o1,o2) -> Integer.compare(o2,o1));
        int idx = 0;
        int turn = 0;
        int answer = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            if(copyMap[idx]==priorities[node]){
                turn++;
                if(node==location) {
                    answer = turn;
                    break;
                }
                idx++;
            }else{
                q.offer(node);
            }
        }
        return answer;
    }
}
