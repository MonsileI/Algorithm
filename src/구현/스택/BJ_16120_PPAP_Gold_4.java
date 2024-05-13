package 구현.스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_16120_PPAP_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        String ppap = "PPAP";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<N;i++){
            char ch = str.charAt(i);
            stack.push(ch);
            if(stack.size()>3){
                int idx = 0;
                boolean check = true;
                for(int j=stack.size()-4;j<stack.size();j++){
                    if(stack.get(j)!=ppap.charAt(idx++)) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    for(int j=0;j<4;j++) stack.pop();
                    stack.push('P');
                }
            }
        }
        if(stack.size()==1 && stack.peek()=='P') System.out.println("PPAP");
        else System.out.println("NP");
    }
}
