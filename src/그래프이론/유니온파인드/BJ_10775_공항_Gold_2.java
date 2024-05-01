package 그래프이론.유니온파인드;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10775_공항_Gold_2 {
    static int [] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        boolean[]visited = new boolean[G+1];
        parents = new int[G+1];
        for(int i=1;i<G+1;i++) parents[i] = i;
        int[]arr = new int[P];
        int ans = 0;
        for(int i=0;i<P;i++){
            int num = Integer.parseInt(br.readLine());
            int gate = find(num);
            if(gate==0) break;
            ans++;
            union(gate,gate-1);
        }
        System.out.println(ans);
        br.close();
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
