package 전체문제.sixth_month_2024_05.fourth_2024_05_04;

import java.util.*;
import java.io.*;
public class BJ_10451_순열사이클_Silver_3 {
    static int [] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[]arr = new int[N+1];
            parents = new int[N+1];
            for(int i=1;i<N+1;i++)parents[i] = i;
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<N+1;i++){
                int num = Integer.parseInt(st.nextToken());
                if(find(num)!=find(i)){
                    union(i,num);
                }
            }
            int cnt = 0;
            boolean[]visited = new boolean[N+1];
            for(int i=1;i<N+1;i++){
                int p = find(i);
                if(!visited[p]){
                    visited[p] = true;
                    cnt++;
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb.toString());

    }
    static void union(int a,int b){
        int rootA = find(a); int rootB= find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
}
