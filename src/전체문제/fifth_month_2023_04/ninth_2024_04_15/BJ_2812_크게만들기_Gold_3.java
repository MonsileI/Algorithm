package 전체문제.fifth_month_2023_04.ninth_2024_04_15;

import java.util.*;
import java.io.*;
public class BJ_2812_크게만들기_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        boolean flag = false;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(str.charAt(i)+"");
            if(flag) {
                stack.push(num);
                continue;
            }
            if(stack.isEmpty()){
                stack.push(num);
                continue;
            }
            if(stack.peek()<num) {
                while (!stack.isEmpty()) {
                    if (stack.peek() >= num) break;
                    stack.pop();
                    M--;
                    if (M == 0) {
                        flag = true;
                        break;
                    }
                }
            }
            stack.push(num);
        }
        if(M!=0){
            while(true){
                if(M==0) break;
                stack.pop();
                M--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<stack.size();i++)sb.append(stack.get(i));
        System.out.println(sb.toString());

    }
}
