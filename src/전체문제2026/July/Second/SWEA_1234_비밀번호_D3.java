package 전체문제2026.July.Second;

import java.util.*;
import java.io.*;
public class SWEA_1234_비밀번호_D3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = 10;
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<N;i++){
                int n = str.charAt(i) - '0';
                if(!stack.isEmpty()){
                    if(stack.peek()==n) stack.pop();
                    else stack.push(n);
                }else{
                    stack.push(n);
                }
            }
            sb.append("#"+t+" ");
            for(int i=0;i<stack.size();i++){
                sb.append(stack.get(i));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
