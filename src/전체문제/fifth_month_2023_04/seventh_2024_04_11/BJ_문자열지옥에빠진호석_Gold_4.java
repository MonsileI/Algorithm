package 전체문제.fifth_month_2023_04.seventh_2024_04_11;

import java.util.*;
import java.io.*;
public class BJ_문자열지옥에빠진호석_Gold_4 {
    static int N,M;
    static int G;
    static char[][]map;
    static String word;
    static int[][]move = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    static Map<String,Integer> hashMap;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int TC = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        hashMap = new HashMap<>();

        for(int t=0;t<TC;t++){
            word = br.readLine();
            G = word.length();
            if(hashMap.containsKey(word)){
                sb.append(hashMap.get(word)+"\n");
                continue;
            }
            answer = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==word.charAt(0)){
                        dfs(i,j,1);
                    }
                }
            }
            hashMap.put(word,answer);
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int i,int j,int idx){
        if(idx==G){
            answer++;
            return;
        }
        for(int d=0;d<8;d++){
            int ni = (i + move[d][0])%N;
            int nj = (j + move[d][1])%M;
            if(ni<0) ni = N-1;
            if(nj<0) nj = M-1;
            if(map[ni][nj]==word.charAt(idx)){
                dfs(ni,nj,idx+1);
            }
        }
    };
}
