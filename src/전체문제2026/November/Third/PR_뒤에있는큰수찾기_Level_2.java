package 전체문제2026.November.Third;

import java.util.*;

public class PR_뒤에있는큰수찾기_Level_2 {
    public static void main(String[] args) {
        int[]numbers = {9, 1, 5, 3, 6, 2};
        System.out.println(Arrays.toString(solution(numbers)));
    }
    static  int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int N = numbers.length;
        int[] answer = new int[N];
        Arrays.fill(answer,-1);
        for(int i=N-1;-1<i;i--){
            int num = numbers[i];
            while(!stack.isEmpty()){
                if(num < numbers[stack.peek()]){
                    answer[i] = numbers[stack.peek()];
                    break;
                }
                stack.pop();
            }
            stack.push(i);
        }
        return answer;
    }
}
