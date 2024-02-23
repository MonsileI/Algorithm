package 전체문제.third_month_2024_02.fourteenth_2024_02_23;
import java.util.*;
import java.io.*;
public class BJ_5397_키로거_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            String str = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            int N = str.length();
            for(int i=0;i<N;i++){
                char ch = str.charAt(i);
                if(ch=='-'){
                    if(!left.isEmpty()) left.pop();
                }else if(ch=='>'){
                    if(!right.isEmpty()){
                        left.push(right.pop());
                    }
                }else if(ch=='<'){
                    if(!left.isEmpty()){
                        right.push(left.pop());
                    }
                }else{
                    left.push(ch);
                }
            }
            int size = left.size();
            for(int i=0;i<size;i++) sb.append(left.get(i));
            while(!right.isEmpty()) sb.append(right.pop());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
