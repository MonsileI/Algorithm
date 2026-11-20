package 전체문제2026.November.Fourteenth;

import java.util.*;
import java.io.*;
public class BJ_2493_탑_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        int[]answer = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        for(int i=N-1;-1<i;i--){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                answer[stack.pop()] = (i+1);
            }
            stack.push(i);
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<N;i++) sb.append(answer[i]+" ");
        System.out.println(sb.toString());
    }
}
