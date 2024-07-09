package 전체문제.eigth_month_2024_07.fifth_2024_07_09;

import java.util.*;
import java.io.*;

public class BJ_17299_오등큰수_Gold_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]nums = new int[1000001];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            nums[arr[i]]++;
        }
        int[]ans = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            while(!stack.isEmpty()){
                if(nums[arr[stack.peek()]]<nums[arr[i]]){
                    ans[stack.pop()] = arr[i];
                }else break;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) ans[stack.pop()] = -1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) sb.append(ans[i]+" ");
        System.out.println(sb.toString());



    }
}
