package 전체문제2026.February.Thirteenth;

import java.util.*;
import java.io.*;
public class BJ_24391_귀찮은해강이_Gold_5 {
    static int N;
    static int[]parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1;i<N+1;i++){
            parent[i] = i;
        }
        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a) != find(b)){
                union(a,b);
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        int before = Integer.parseInt(st.nextToken());
        int ans = 0;
        for(int i=1;i<N;i++){
            int cur = Integer.parseInt(st.nextToken());
            if(find(before)!=find(cur)){
                ans++;
            }
            before = cur;
        }
        System.out.println(ans);
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
