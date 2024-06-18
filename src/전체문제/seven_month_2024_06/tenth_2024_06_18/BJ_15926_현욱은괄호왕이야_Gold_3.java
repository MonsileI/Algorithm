package 전체문제.seven_month_2024_06.tenth_2024_06_18;

import java.util.*;
import java.io.*;
public class BJ_15926_현욱은괄호왕이야_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0;i<N;i++) {
            char ch = str.charAt(i);
            if (ch == '(') stack.push(i);
            else {
                stack.pop();
                if (!stack.isEmpty()) {
                    ans = Math.max(ans, i - stack.peek());
                } else {
                    stack.add(i);
                }
            }
        }
        System.out.println(ans);
    }
}
