package 트리.LCA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_11437_LCA_Gold_3 {
    static List<Integer>[] list;
    static int[]parent,depth;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        parent = new int[N+1];
        depth = new int[N+1];
        for(int i=1;i<N+1;i++)list[i] = new ArrayList<>();
        StringTokenizer st= null;
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        make(1,1,0);
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            sb.append(LCA(a,b)+"\n");
        }
        System.out.println(sb.toString());
    }
    static int LCA(int a,int b){
        int aHegiht = depth[a];
        int bHegiht = depth[b];

        while(aHegiht > bHegiht) {
            a = parent[a];
            aHegiht--;
        }

        while(bHegiht > aHegiht) {
            b = parent[b];
            bHegiht--;
        }

        while(a!=b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
    static void make(int now,int height, int pa){
        depth[now] = height;
        parent[now] = pa;
        for(int next : list[now]){
            if(next != pa){
                make(next,height+1,now);
            }
        }
    }
}
