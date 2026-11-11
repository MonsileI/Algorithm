package 전체문제2026.November.Seventh;

import java.util.*;
import java.io.*;
public class SWEA_3289_서로소집합_D4 {
    static int[]parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st= new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            parent = new int[N+1];
            for(int i=1;i<=N;i++) parent[i] = i;
            sb.append("#"+t+" ");
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int act = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                // 0 집합 만들기
                // 1 확인하기
                if(act==0){
                    union(a,b);
                }
                if(act==1){
                    if(find(a)!=find(b)) sb.append("0");
                    else sb.append("1");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }
    static int find(int node){
        if(parent[node]==node) return node;
        return parent[node] = find(parent[node]);
    }
}
