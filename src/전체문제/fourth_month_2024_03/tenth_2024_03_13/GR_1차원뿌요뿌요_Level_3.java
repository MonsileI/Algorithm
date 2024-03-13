package 전체문제.fourth_month_2024_03.tenth_2024_03_13;
import java.util.*;
import java.io.*;
public class GR_1차원뿌요뿌요_Level_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        OuterLoop:
        while(idx<N){
            char ch = str.charAt(idx);
            stack.push(ch);
            int size = stack.size();
            if(size>=M){
                boolean flag = true;
                size--;
                char tmp = stack.peek();
                for(int i=size;size-M<i;i--){
                    if(stack.get(i)!=tmp){
                        flag= false;
                        break;
                    }
                }
                if(flag){
                    for(int i=0;i<M;i++) stack.pop();
                    while(true){
                        if(ch!=str.charAt(idx)) {
                            idx--;
                            break;
                        }
                        idx++;
                        if(idx==N) break OuterLoop;
                    }
                }
            }
            idx++;
        }
        if(stack.isEmpty()) System.out.println(" CLEAR!");
        else {
            int size = stack.size();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) sb.append(stack.get(i));
            System.out.println(sb.toString());
        }
    }
}
