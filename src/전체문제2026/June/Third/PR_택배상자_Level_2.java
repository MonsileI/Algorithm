package 전체문제2026.June.Third;

import java.util.*;

public class PR_택배상자_Level_2 {
    public static void main(String[] args) {
        int[]order = {4, 3, 1, 2, 5};
        System.out.println(solution(order));
    }
    static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int cur = 1;
        int N = order.length;
        for(int i=0;i<N;i++){
            int target = order[i];
            if(cur <= target){
                while(cur != target){
                    stack.push(cur++);
                }
                cur++;
                answer++;
            }
            else{
                if(stack.isEmpty() || stack.peek() != target) break;
                else{
                    answer++;
                    stack.pop();
                }
            }
        }
        return answer;
    }
}
