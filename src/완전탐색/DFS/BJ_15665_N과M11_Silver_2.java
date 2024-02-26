package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15665_N과M11_Silver_2 {
    static int N,M;
    static List<Integer> list;
    static int[]tmp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[]check = new boolean[10001];
        st =new StringTokenizer(br.readLine()," ");
        list=  new ArrayList<>();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(!check[num]){
                check[num] = true;
                list.add(num);
            }
        }
        N = list.size();
        tmp = new int[M];
        Collections.sort(list);
        perm(0);
        System.out.println(sb.toString());
    }
    static void perm(int depth){
        if(depth==M){
            sb.append(list.get(tmp[0])+" ");
            for(int i=1;i<M;i++) sb.append(list.get(tmp[i])+" ");
            sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            tmp[depth] = i;
            perm(depth+1);
        }
    }
}
