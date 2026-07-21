package 전체문제2026.July.Ninth;

import java.util.*;

public class PR_짝지어제거하기_Level_2 {
    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }
    static  int solution(String s) {
        int answer = 0;
        int N = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<N;i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty()){
                if(stack.peek()==ch) stack.pop();
                else stack.push(ch);
            }else{
                stack.push(ch);
            }
        }
        if(stack.isEmpty()) answer = 1;

        return answer;
    }
}
