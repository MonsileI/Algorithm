package 구현.스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

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
