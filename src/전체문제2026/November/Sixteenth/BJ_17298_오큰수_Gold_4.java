package 전체문제2026.November.Sixteenth;

import java.util.*;
import java.io.*;
public class BJ_17298_오큰수_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr =new int[N];
        int[]answer=  new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(answer,-1);
        for(int i=0;i<N;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        StringBuilder sb=  new StringBuilder();
        for(int i=0;i<N;i++) sb.append(answer[i]+" ");
        System.out.println(sb.toString());
    }
}
