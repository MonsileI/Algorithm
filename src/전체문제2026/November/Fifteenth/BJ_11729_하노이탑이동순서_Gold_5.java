package 전체문제2026.November.Fifteenth;

import java.util.*;
import java.io.*;
public class BJ_11729_하노이탑이동순서_Gold_5 {
    static int N;
    static StringBuilder sb;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        dfs(1,3,2,0);
        System.out.println(answer);
        System.out.println(sb.toString());
    }
    static void dfs(int from,int to,int mid,int depth){
        if(depth==N) return;
        dfs(from, mid, to, depth + 1);
        sb.append(from+" "+to+"\n");
        dfs(mid, to, from, depth + 1);
        answer++;
    }
}
