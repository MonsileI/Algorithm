package 전체문제.fifth_month_2023_04.fourteenth_2024_04_22;

import java.util.*;
import java.io.*;
public class BJ_11724_연결요소의개수_Silver_2 {
    static int [] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i=1;i<N+1;i++) parents[i] = i;
        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine()," ");
            int a=  Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());
            if(find(a)!=find(b)){
                union(a,b);
            }
        }
        int ans = 0;
        boolean[]visited=  new boolean[N+1];
        for(int i=1;i<N+1;i++){
            int p = find(i);
            if(!visited[p]) {
                visited[p] = true;
                ans++;
            }
        }
        System.out.println(ans);

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