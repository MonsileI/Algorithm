package 전체문제.fourth_month_2024_03.second_2024_03_04;
import java.util.*;
public class PR_올바른괄호_Level_1 {
    static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        int size = s.length();
        for(int i=0;i<size;i++){
            char ch = s.charAt(i);
            if(ch==')'){
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                }else stack.pop();
            }else{
                stack.push(ch);
            }
        }
        if(!stack.isEmpty()) answer = false;
        return answer;
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        String s = "()()";
        boolean answer = true;
        2.
        String s = "(())()";
        boolean answer = true;
        3.
        String s = ")()(";
        boolean answer = false;
        4.
        String s = "(()(";
        boolean answer = false;
        * */
        String s = "()()";
        System.out.println(solution(s));
    }
}
