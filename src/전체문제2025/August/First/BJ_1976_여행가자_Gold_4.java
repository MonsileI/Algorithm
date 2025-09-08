package 전체문제2025.August.First;

import java.util.*;
import java.io.*;
public class BJ_1976_여행가자_Gold_4 {
    static int N;
    static int [] parents;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        Make();
        for(int i=1;i<N+1;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < N + 1; j++) {
                int YN = Integer.parseInt(st.nextToken());
                if(YN==1){
                    union(i,j);
                }
            }
        };
        st = new StringTokenizer(br.readLine()," ");
        int startNode = Integer.parseInt(st.nextToken());
        boolean flag = true;
        for(int i=1;i<M;i++){
            int node = Integer.parseInt(st.nextToken());
            if(flag == false) {
                continue;
            }
            if(parents[startNode] != parents[node]){
                flag = false;
            }else{
                startNode = parents[node];
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }

    static int find(int num){
        if(parents[num] == num) {
            return num;
        }
        return parents[num] = find(parents[num]);
    }
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA < rootB){
            parents[rootB] = rootA;
        }else{
            parents[rootA] = rootB;
        }
    }
    static void Make(){
        for(int i=0;i<N+1;i++){
            parents[i] = i;
        }
    }
}
