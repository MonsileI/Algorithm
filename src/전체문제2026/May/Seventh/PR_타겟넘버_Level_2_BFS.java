package 전체문제2026.May.Seventh;

import java.util.*;

public class PR_타겟넘버_Level_2_BFS {

    public static void main(String[] args) {
        int[]numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers,target));
    }
    static int solution(int[] numbers, int target) {
        int answer = 0;
        int N = numbers.length;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int depth = c[0]; int sum = c[1];
            if(depth==N) {
                if(sum==target) answer++;
                continue;
            }
            q.offer(new int[]{depth+1,sum+numbers[depth]});
            q.offer(new int[]{depth+1,sum-numbers[depth]});
        }
        return answer;
    }
}
