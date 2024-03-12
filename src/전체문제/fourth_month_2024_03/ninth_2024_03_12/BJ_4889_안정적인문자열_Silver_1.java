package 전체문제.fourth_month_2024_03.ninth_2024_03_12;
import java.util.*;
import java.io.*;
public class BJ_4889_안정적인문자열_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;
        StringBuilder sb= new StringBuilder();
        while(true){
            String str =br.readLine();
            if(str.charAt(0)=='-') break;
            Stack<Character> stack = new Stack<>();
            int N = str.length();
            int ans = 0;
            for(int i=0;i<N;i++){
                char ch = str.charAt(i);
                if(ch=='{') stack.push(ch);
                else{
                    if(stack.isEmpty()){
                        ans++;
                        stack.push('{');
                    }else stack.pop();
                }
            }

            sb.append(tc+". "+((stack.size()/2)+ans)+"\n");
            tc++;
        }
        System.out.println(sb.toString());
    }
}
