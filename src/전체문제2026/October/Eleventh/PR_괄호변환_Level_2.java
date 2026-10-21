package 전체문제2026.October.Eleventh;

import java.util.*;

public class PR_괄호변환_Level_2 {
    public static void main(String[] args) {
        String p = "()))((()";
        System.out.println(solution(p));
    }
    static String solution(String p) {
        String answer = dfs(p);
        return answer;
    }
    static String dfs(String p){
        if(p.isBlank()) return "";
        int idx = 0;
        int leftCnt = 0; int rightCnt = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            if(ch=='(') {
                stack.push('(');
                leftCnt++;
            }
            else {
                if(!stack.isEmpty()){
                    if(stack.peek()=='(') stack.pop();
                }
                rightCnt++;
            }
            if(leftCnt==rightCnt){
                idx = (i+1);
                break;
            }
        }
        String u = p.substring(0,idx);
        String v = p.substring(idx);
        if(stack.isEmpty()) return u + dfs(v);
        String result = "(" + dfs(v) + ")";
        for(int i=1;i<u.length()-1;i++){
            if(u.charAt(i)=='(') result += ')';
            else result += '(';
        }
        return result;
    }
}
