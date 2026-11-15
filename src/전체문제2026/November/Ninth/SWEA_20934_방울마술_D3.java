package 전체문제2026.November.Ninth;

import java.util.*;
import java.io.*;
public class SWEA_20934_방울마술_D3 {
    static int answer;
    static boolean[][]visited;
    static int K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            String str = st.nextToken();
            answer = 4;
            K = Integer.parseInt(st.nextToken());
            int firPos = 0;
            visited = new boolean[K][3];
            if(str.charAt(1)=='o') firPos = 1;
            if(str.charAt(2)=='o') firPos = 2;
            dfs(firPos,0);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int pos,int depth){
        if(depth==K){
            answer = Math.min(answer,pos);
            return;
        }
        if(visited[depth][pos]) return;
        visited[depth][pos] = true;
        if(0<pos) dfs(pos-1,depth+1);
        if(pos<2) dfs(pos+1,depth+1);
    }
}
