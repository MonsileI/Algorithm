package 전체문제.sixth_month_2024_05.fourth_2024_05_04;

import java.util.*;
import java.io.*;
public class BJ_17299_오등큰수_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]count = new int[1000001];
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            count[num]++;
        }
        Stack<Integer> stack = new Stack<>();
        int[]ans = new int[N];
        for(int i=0;i<N;i++){
            int num = arr[i];
            while(!stack.isEmpty()){
                if(count[arr[stack.peek()]]<count[num]) ans[stack.pop()] = num;
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
