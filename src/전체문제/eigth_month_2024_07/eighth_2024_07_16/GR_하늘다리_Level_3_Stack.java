package 전체문제.eigth_month_2024_07.eighth_2024_07_16;

import java.util.*;
import java.io.*;
public class GR_하늘다리_Level_3_Stack {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()){
                stack.push(num);
                continue;
            }
            if(stack.peek()<=num){
                while(!stack.isEmpty()){
                    if(stack.peek()==num) {
                        ans++;
                        stack.pop();
                        break;
                    }
                    if(stack.peek()>num) break;
                    stack.pop();
                }
            }
            stack.push(num);
        }
        System.out.println(ans);
    }
}
