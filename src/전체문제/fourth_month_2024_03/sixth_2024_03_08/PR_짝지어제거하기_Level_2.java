package 전체문제.fourth_month_2024_03.sixth_2024_03_08;
import java.util.*;

public class PR_짝지어제거하기_Level_2 {

    static int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        int size = s.length();
        for(int i=0;i<size;i++){
            char ch = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
            }else{
                if(stack.peek()==ch) stack.pop();
                else stack.push(ch);
            }
        }
        //abbacaccac
        while(!stack.isEmpty()){

        }
        if(stack.isEmpty()) answer = 1;
        return answer;
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        String s = "baabaa";
        int return = 1;

        2.
        String s = "cdcd";
        int return = 0;
        * */
        String s = "cdcd";
        System.out.println(solution(s));
    }
}
