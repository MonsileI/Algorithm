package 그래프이론.유니온파인드;
import java.util.*;
import java.io.*;
public class bj_1717_집합의표현_Gold_5 {
    static int N;
    static int[]parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        make(); // parents 배열을 넣어줌(자기 부모가 누군지 저장하는 배열)
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int act = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(act==0) union(a,b);
            else{
                if(find(a)!=find(b)) sb.append("NO");
                else sb.append("YES");
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static void make(){
        parents = new int[N+1];
        for(int i=1;i<N+1;i++)parents[i] = i;
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA<rootB) parents[rootB] =rootA;
        else parents[rootA] = rootB;
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num]=find(parents[num]);
    }

}
