package 전체문제2026.June.Twelfth;

import java.util.*;
import java.io.*;
public class SWEA_25838_여우줄이기_D4  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        char[] fox = {'x','o','f'};
        while(0<TC){
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Stack<Character> stack =new Stack<>();
            for(int i=0;i<N;i++){
                char ch = str.charAt(i);
                stack.push(ch);
                if(3<=stack.size()){
                    int idx = 0;
                    boolean flag = true;
                    for(int j=stack.size()-1;stack.size()-3<=j;j--){
                        if(stack.get(j)!=fox[idx++]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        for(int j=0;j<3;j++) stack.pop();
                    }
                }
            }
            sb.append(stack.size()+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
