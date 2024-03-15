package 전체문제.fourth_month_2024_03.twelfth_2024_03_15;
import java.util.*;
import java.io.*;
public class BJ_9935_문자열폭발_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f = br.readLine();
        String s = br.readLine();
        int N = f.length();
        int M = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<N;i++){
            char ch  = f.charAt(i);
            stack.push(ch);
            if(stack.size()>=M){
                boolean flag = true;
                int idx = 0;
                for(int j=stack.size()-M;j<stack.size();j++){
                    if(s.charAt(idx++)!=stack.get(j)){
                        flag= false;
                        break;
                    }
                }
                if(flag){
                    for(int j=0;j<M;j++)stack.pop();
                }
            }
        }
        if(stack.isEmpty()) System.out.println("FRULA");
        else{
            StringBuilder sb= new StringBuilder();
            for(int i=0;i<stack.size();i++)sb.append(stack.get(i));
            System.out.println(sb.toString());
        }
    }
}
