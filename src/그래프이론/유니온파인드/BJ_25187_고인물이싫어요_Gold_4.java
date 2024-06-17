package 그래프이론.유니온파인드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_25187_고인물이싫어요_Gold_4 {
    static int N;
    static int[]parents;
    static int [] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        dist = new int[N+1];
        for(int i=1;i<N+1;i++)parents[i] = i;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++) {
            int num = Integer.parseInt(st.nextToken());
            dist[i] = (num==1 ? 1 : -1);
        }
        for(int i=0;i<M;i++){
            st=  new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        int[]arr = new int[N+1];
        for(int i=1;i<N+1;i++){
            int p = find(i);
            arr[p] += dist[i];
        }
        for(int i=1;i<N+1;i++){
            int p = find(i);
            arr[i] = arr[p];
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<Q;i++){
            int p = find(Integer.parseInt(br.readLine()));
            if(arr[p]>0) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
}
