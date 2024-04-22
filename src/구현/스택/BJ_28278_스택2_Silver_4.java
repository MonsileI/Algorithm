package 구현.스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_28278_스택2_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int TC  = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Stack<Integer> stack = new Stack<>();
        for(int t=0;t<TC ;t++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num==1){
                stack.push(Integer.parseInt(st.nextToken()));
            }else{
                switch (num){
                    case 2 : if(stack.isEmpty()) sb.append(-1+"\n");
                             else sb.append(stack.pop()+"\n");
                        break;
                    case 3 : sb.append(stack.size()+"\n");
                        break;
                    case 4 : if(stack.isEmpty()) sb.append(1+"\n");
                             else sb.append(0+"\n");
                        break;
                    case 5 : if(stack.isEmpty())sb.append(-1+"\n");
                             else sb.append(stack.peek()+"\n");
                        break;
                }
            }
        }
        System.out.println(sb.toString());

    }
}
