package 전체문제.sixth_month_2024_05.fifth_2024_05_07;

import java.util.*;
import java.io.*;
public class BJ_3986_좋은단어_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int t=0;t<TC;t++){

            String str = br.readLine();
            int N = str.length();

            if(N%2==1) continue;

            Stack<Character> stack = new Stack<>();
            for(int i=0;i<N;i++){
                char ch = str.charAt(i);
                if(stack.isEmpty()) {
                    stack.push(ch);
                    continue;
                }
                if(stack.peek()==ch) stack.pop();
                else stack.push(ch);
            }
            if(stack.isEmpty())ans++;
        }
        System.out.println(ans);
    }
}
