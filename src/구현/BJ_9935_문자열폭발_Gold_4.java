package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9935_문자열폭발_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String comp = br.readLine();
        int N = str.length();
        int C = comp.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<N;i++){
            char ch = str.charAt(i);
            stack.push(ch);
            if(stack.size()>=C){
                int idx = 0;
                boolean flag = true;
                while(true){
                    if(comp.charAt(C-idx-1)!=stack.get(stack.size()-idx-1)){
                        flag = false;
                        break;
                    }
                    idx++;
                    if(idx==C) break;
                }
                if(flag){
                    for(int j=C-1;-1<j;j--) stack.pop();
                }
            }
        }
        if(stack.isEmpty()) System.out.println("FRULA");
        else{
            StringBuilder sb= new StringBuilder();
            for(int i=0;i<stack.size();i++){
                sb.append(stack.get(i));
            }
            System.out.println(sb.toString());
        }
    }
}
