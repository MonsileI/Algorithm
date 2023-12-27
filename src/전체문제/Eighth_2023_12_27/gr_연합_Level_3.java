package 전체문제.Eighth_2023_12_27;
import java.util.*;
import java.io.*;
public class gr_연합_Level_3 {
    static int [] parents;
    static int N;
    public static void main(String[] args)throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i=1;i<N+1;i++)parents[i] = i;
        boolean[][]check = new boolean[N+1][N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            check[a][b] = true;
            if(check[b][a]) union(a,b);
        }
        boolean[]visited = new boolean[N+1];
        int ans = 0;
        for(int i=1;i<N+1;i++){
            int node = find(parents[i]);
            if(!visited[node]){
                visited[node] = true;
                ans++;
            }
        }
        System.out.println(ans);
    }

    static void union(int a,int b){
        int rootA = find(a); int rootB=  find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
}
