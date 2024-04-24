package 전체문제.fifth_month_2023_04.sixteenth_2024_04_24;

import java.util.*;
import java.io.*;
public class BJ_17298_오큰수_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        int[]ans = new int[N];
        for(int i=0;i<N;i++){
            int num = arr[i];
            while(!stack.isEmpty()){
                if(arr[stack.peek()]<num) ans[stack.pop()] = num;
                else break;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) ans[stack.pop()] = -1;
        StringBuilder sb=  new StringBuilder();
        for(int i=0;i<N;i++)sb.append(ans[i]+" ");
        System.out.println(sb.toString());
    }
}
