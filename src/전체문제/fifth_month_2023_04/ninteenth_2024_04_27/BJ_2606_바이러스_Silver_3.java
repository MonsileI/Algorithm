package 전체문제.fifth_month_2023_04.ninteenth_2024_04_27;

import java.util.*;
import java.io.*;
public class BJ_2606_바이러스_Silver_3 {
    static int [] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        for(int i=1;i<N+1;i++) parents[i] = i;
        StringTokenizer st = null;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            union(a,b);
        }
        int ans = 0;
        for(int i=2;i<N+1;i++){
            int p = find(i);
            if(p==1) ans++;
        }
        System.out.println(ans);

    }
    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
}
