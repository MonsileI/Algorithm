package 전체문제2026.June.First;

import java.util.*;
public class PR_짝지어제거하기_Level_2 {
    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }
    static int solution(String s){
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        int N = s.length();
        for(int i=0;i<N;i++){
            char ch  =s.charAt(i);
            if(stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if(stack.peek()==ch){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        answer = stack.isEmpty() ? 1 : 0;
        return answer;
    }

}
