package 전체문제2026.April.Third;

import java.util.*;
import java.io.*;
public class BJ_5568_카드놓기_Silver_4 {
    static int N,K;
    static int[]arr;
    static int[]tmp;
    static Set<Integer> set;
    static boolean[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        set = new HashSet<>();
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        tmp = new int[K];
        perm(0);
        System.out.println(set.size());
    }
    static void perm(int depth){

        if(depth==K){
            String str = "";
            for(int i=0;i<K;i++) str += arr[tmp[i]];
            set.add(Integer.parseInt(str));
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = i;
                perm(depth+1);
                visited[i] = false;
            }
        }
    }
}
