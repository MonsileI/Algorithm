package 전체문제.twleveth_month_2025_04.first_25_03_28;

import java.util.*;
import java.io.*;
public class BJ_9935_문자열폭발_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();
        int N = str.length();
        int M = bomb.length();

        for(int i=0;i<N;i++){
            char ch = str.charAt(i);
            stack.push(ch);

            if(stack.size()>=M){
                boolean flag = true;
                int idx =0;
                for(int j=stack.size()-M;j<stack.size();j++){
                    if(stack.get(j) != bomb.charAt(idx++)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int j=0;j<M;j++) stack.pop();
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();
        if(stack.isEmpty()) sb.append("FRULA");
        else {
            for (int i = 0; i < stack.size(); i++) sb.append(stack.get(i));
        }
        System.out.println(sb.toString());
    }
}
