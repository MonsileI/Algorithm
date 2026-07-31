package 전체문제2026.July.Thirteenth;

import java.util.*;
import java.io.*;
public class SWEA_1218_괄호짝짓기_D4  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = 10;
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            // '()', '[]', '{}', '<>'
            for(int i=0;i<N;i++){
                char ch = str.charAt(i);
                if(ch=='('||ch=='['||ch=='{'||ch=='<'){
                    stack.push(ch);
                    continue;
                }
                char tch = stack.peek();
                if((tch=='(' && ch==')') || (tch=='[' && ch==']') || (tch=='{' && ch=='}') || (tch=='<' && ch=='>')){
                    stack.pop();
                }else break;
            }
            sb.append("#"+t+" ");
            if(stack.isEmpty()) sb.append(1);
            else sb.append(0);
            sb.append("\n");

        }
        System.out.println(sb.toString());
    }
}
