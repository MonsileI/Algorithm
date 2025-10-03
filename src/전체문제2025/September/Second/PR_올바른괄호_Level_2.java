package 전체문제2025.September.Second;

import java.util.*;

public class PR_올바른괄호_Level_2 {
    public static void main(String[] args) {
        /*

        String s= "()()"; answer = true;
        String s = "(())()"; answer = true;
        String s = ")()("; answer = false;
        String s = "(()("; answer = false;
        */
        String s = "(())()";
        System.out.println(solution(s));
    }
    static boolean solution(String s){
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch =='('){
                stack.push(ch);
            }else{
                if(stack.isEmpty()) return false;
                if(stack.peek() != '('){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.isEmpty() == false) return false;
        return true;
    }
}
