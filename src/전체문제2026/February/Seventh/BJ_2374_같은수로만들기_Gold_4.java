package 전체문제2026.February.Seventh;

import java.util.*;
import java.io.*;
public class BJ_2374_같은수로만들기_Gold_4 {
    static int N;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr= new int[N];
        int max = 0;
        int maxIdx = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(max<arr[i]){
                max = arr[i];
                maxIdx = i;
            }
        }
        long answer = 0;
        answer += dfs(0,maxIdx-1,max);
        answer += dfs(maxIdx+1,N-1,max);
        System.out.println(answer);
    }
    static long dfs(int start,int end, int limit){
        int max = 0;
        int maxIdx = 0;
        if(start<0 || end<0 || N-1<start || N-1<end || end<start) return 0;
        for(int i=start;i<end+1;i++){
            if(max<arr[i]){
                max = arr[i];
                maxIdx = i;
            }
        }

        long answer = limit - max;
        answer += dfs(start,maxIdx-1,max);
        answer += dfs(maxIdx+1,end,max);
        return answer;
    }
}
