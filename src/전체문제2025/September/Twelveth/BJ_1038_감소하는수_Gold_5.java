package 전체문제2025.September.Twelveth;

import java.util.*;
import java.io.*;
public class BJ_1038_감소하는수_Gold_5 {
    static List<Long> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        if(1022 < N){
            answer = -1;
        }else{
            list = new ArrayList<>();
            for(int i=0;i<10;i++){
                dfs(i,1);
            }
            Collections.sort(list);
            answer = list.get(N);
        }
        System.out.println(answer);
    }
    static void dfs(long num, int idx){
        if(idx > 10) return;
        list.add(num);
        for(int i=0;i<num%10;i++){
            dfs((num*10)+i,idx+1);
        }

    }
}
