package 전체문제2026.September.Fourth;

import java.util.*;
import java.io.*;
public class GR_그룹지정_D4 {
    static int []parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1;i<=N;i++) parent[i] = i;
        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (find(a) != find(b)) {
                union(a,b);
            }
        }

        boolean[]isCheck = new boolean[N+1];
        int answer = 0;
        for(int i=1;i<=N;i++){
            int p = find(parent[i]);
            if(!isCheck[p]){
                isCheck[p] = true;
                answer++;
            }
        }
        System.out.println(answer);
    }
    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }
    static int find(int node){
        if(parent[node]==node) return node;
        return parent[node] = find(parent[node]);
    }
}
