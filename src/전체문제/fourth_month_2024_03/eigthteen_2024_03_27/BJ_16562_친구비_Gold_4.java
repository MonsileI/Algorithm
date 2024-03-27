package 전체문제.fourth_month_2024_03.eigthteen_2024_03_27;

import java.util.*;
import java.io.*;
public class BJ_16562_친구비_Gold_4 {
    static int N;
    static int [] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i=1;i<N+1;i++) parents[i] = i;
        int M = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int[]weight = new int[N+1];
        for(int i=1;i<N+1;i++) weight[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==b) continue;
            if(find(a)!=find(b)) union(a,b);
        }
        boolean[]visited=  new boolean[N+1];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<N+1;i++){
            int p = find(i);
            if(!visited[p]){
                visited[p] = true;
                map.put(p,weight[i]);
            }
            map.put(p,Math.min(map.get(p),weight[i]));
        }
        int ans = 0;
        boolean flag = true;
        for(Integer key : map.keySet()){
            ans += map.get(key);
            if(ans > money) {
                flag =false;
                break;
            }
        }
        System.out.println(flag ? ans : "Oh no");
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
