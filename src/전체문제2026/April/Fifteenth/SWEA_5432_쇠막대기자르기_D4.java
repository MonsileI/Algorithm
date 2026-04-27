package 전체문제2026.April.Fifteenth;

import java.util.*;
import java.io.*;
public class SWEA_5432_쇠막대기자르기_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC  =Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=TC;t++){
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            int N = str.length();
            int answer = 0;
            for(int i=0;i<N;i++){
                char ch = str.charAt(i);
                if(ch=='(') stack.push(ch);
                else{
                    char topNode = str.charAt(i-1);
                    if(topNode=='('){
                        stack.pop();
                        answer += stack.size();
                    }
                    else{
                        answer++;
                        stack.pop();
                    }

                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
