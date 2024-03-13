package 전체문제.fourth_month_2024_03.tenth_2024_03_13;
import java.util.*;
import java.io.*;
public class GR_그룹지정_Level_4 {
    static int N;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents =new int[N+1];
        for(int i=1;i<N+1;i++) parents[i] = i;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        boolean[]visited=  new boolean[N+1];
        int ans = 0;
        for(int i=1;i<N+1;i++){
            int parent = find(i);
            if(!visited[parent]){
                visited[parent] = true;
                ans++;
            }
        }
        System.out.println(ans);
    }
    static void union (int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
}
